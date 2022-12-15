package br.com.kangu.muser.entities;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique=true)
    private String document;

    @Column(unique=true)
    private String email;
    private String password;

    private String type;


}
