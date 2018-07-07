package edu.dhbw.ka.mwi.businesshorizon2.models.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity(name = "AppRole")
@Table(name = "AppRole")
public class AppRoleDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppRoleId")
	@ApiModelProperty()
    private Long appRoleId;

    @Column(name="RoleName", columnDefinition = "nvarchar")
	@ApiModelProperty()
    private String roleName;

    @Column(name="RoleDescription", columnDefinition = "nvarchar")
	@ApiModelProperty()
    private String roleDescription;

    @ManyToMany(mappedBy = "appRoles")
	@ApiModelProperty()
    private List<AppUserDao> appUsers = new ArrayList<>();
    
    public Long getId() { return appRoleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getDescription() { return roleDescription; }
    public void setDescription(String roleDescription) { this.roleDescription = roleDescription; }
}

