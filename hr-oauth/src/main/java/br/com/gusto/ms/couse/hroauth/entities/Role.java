package br.com.gusto.ms.couse.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String roleName;

	public Role() {
	}

	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Role role = (Role) o;

		if (!Objects.equals(id, role.id)) return false;
		return Objects.equals(roleName, role.roleName);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
		return result;
	}
}
