

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    public Role() {}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() { return roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
