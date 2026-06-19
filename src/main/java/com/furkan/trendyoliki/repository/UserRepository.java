      package com.furkan.trendyoliki.repository;

      import org.springframework.data.jpa.repository.JpaRepository;

      import com.furkan.trendyoliki.entity.User;

      public interface UserRepository extends  JpaRepository<User,Integer> {
            User findByUsername(String username);
      }
