package com.forumhub.forumhub.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@IdClass(UserRole.UserRoleId.class)
public class UserRole {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "role_id")
    private Long roleId;

    public static class UserRoleId implements Serializable {
        private Long userId;
        private Long roleId;

        // getters and setters, equals, and hashCode methods
    }
}

