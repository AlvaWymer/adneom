package com.adneom.bean;

import com.adneom.bean.abs.AbstractAuditing;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @ClassName: Client
 * @Description: Bean for Client
 * @Author: Yang Naihua
 * @Create: 2018-06-18 10:27
 **/
@Entity
@Table(name = "clients")
@Data
@ApiModel(value = "Client", description = "Client/客户")
public class Client extends AbstractAuditing {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @ApiModelProperty(value = "ID", readOnly = true)
    private String id;

    @NotNull
    @Column(unique = true)
    @ApiModelProperty(value = "Compte/用户名", required = true)
    private String username;

    @ApiModelProperty(value = "Nom/姓", readOnly = true)
    private String firstName;

    @ApiModelProperty(value = "Prenom/名", readOnly = true)
    private String lastName;

    @NotNull
    @ApiModelProperty(value = "Mot de passe/密码", required = true)
    private String password;

    @NotNull
    @ApiModelProperty(value = "Email/邮箱", required = true)
    private String email;

    @NotNull
    @ApiModelProperty(value = "Phone/电话号码")
    private String phoneNumber;

    @ApiModelProperty(value = "Langue/语言")
    private String language;

    @ApiModelProperty(value = "Date de naissance/生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "Activation/是否已经激活", readOnly = true)
    private Boolean activate = true;

    @ApiModelProperty(value = "Avatar/头像地址", readOnly = true)
    private String iconAddressUrl;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Type de client/客户类型", readOnly = true)
    private ClientType clientType = ClientType.CLIENT;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Sexisme/性别", readOnly = true)
    private SexeType sexe = SexeType.SECRET;
}