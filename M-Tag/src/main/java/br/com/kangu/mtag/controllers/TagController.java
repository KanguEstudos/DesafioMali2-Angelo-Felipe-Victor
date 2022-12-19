package br.com.kangu.mtag.controllers;

import br.com.kangu.mtag.entity.Order;
import br.com.kangu.mtag.repositories.OrderRepository;
import com.lowagie.text.DocumentException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/{id}")
    private ResponseEntity<Resource> parseThymeleafTemplate(@PathVariable Long id) throws DocumentException, IOException {

        Order order = orderRepository.findById(id).get();

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        int min = 50;
        int max = 1000;

        Integer random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        String url = "https://brasilapi.com.br/api/cep/v2/" + order.getCEPOrigin();
        RestTemplate restTemplate = new RestTemplate();
        String endereco_origem = restTemplate.getForObject(url, String.class);

        JSONObject endereco_origem_json = new JSONObject(endereco_origem);

        String url2 = "https://brasilapi.com.br/api/cep/v2/" + order.getCEPDestin();
        RestTemplate restTemplate2 = new RestTemplate();
        String endereco_destino = restTemplate2.getForObject(url2, String.class);

        JSONObject endereco_destino_json = new JSONObject(endereco_destino);

        endereco_destino_json.getString("cep");

        Context context = new Context();
        context.setVariable("random", random_int.toString());
        context.setVariable("order_id", order.getId().toString());
        context.setVariable("nome_cliente", order.getSeller().getName().toString());
        context.setVariable("logradouro_endereco_cliente", endereco_origem_json.getString("street"));
        context.setVariable("bairro_endereco_cliente", endereco_origem_json.getString("neighborhood"));
        context.setVariable("cep_endereco_cliente", endereco_origem_json.getString("cep"));
        context.setVariable("cidade_endereco_cliente", endereco_origem_json.getString("city"));
        context.setVariable("uf_endereco_cliente", endereco_origem_json.getString("state"));
        context.setVariable("nome_cliente_dest", order.getBuyer().getName().toString());
        context.setVariable("logradouro_endereco_cliente_dest", endereco_destino_json.getString("street"));
        context.setVariable("bairro_endereco_cliente_dest", endereco_destino_json.getString("neighborhood"));
        context.setVariable("cep_endereco_cliente_dest", endereco_destino_json.getString("cep"));
        context.setVariable("cidade_endereco_cliente_dest", endereco_destino_json.getString("city"));
        context.setVariable("uf_endereco_cliente_dest", endereco_destino_json.getString("state"));

        generatePdfFromHtml(templateEngine.process("thymeleaf_template", context));

        File file = new File(System.getProperty("user.home") + File.separator + "thymeleaf.pdf");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);

    }

    public void generatePdfFromHtml(String html) throws IOException, DocumentException {
        String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }

}
