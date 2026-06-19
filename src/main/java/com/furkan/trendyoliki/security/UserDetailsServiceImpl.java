package com.furkan.trendyoliki.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.furkan.trendyoliki.entity.User;
import com.furkan.trendyoliki.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        System.out.println("--- GÜVENLİK KONTROLÜ BAŞLADI ---");
        System.out.println("POSTMAN'DEN GELEN KULLANICI ADI: [" + username + "]");

        User user = userRepository.findByUsername(username);
        
        if (user == null) {
            System.out.println("🚨 HATA: Veritabanında böyle bir kullanıcı bulunamadı! (İsimde boşluk kalmış olabilir)");
            throw new UsernameNotFoundException("User could not be found");
        }
        
        System.out.println("✅ KULLANICI BULUNDU: " + user.getUsername());
        System.out.println("🔑 VERİTABANINDAKİ ŞİFRE (HASH): " + user.getPassword());
        System.out.println("🛡️ KULLANICININ ROLÜ: " + user.getRole().name());
        System.out.println("---------------------------------");
        
        return org.springframework.security.core.userdetails.User
    .withUsername(user.getUsername())  // getUsername() küçük u
    .password(user.getPassword())
    .roles(user.getRole().name())      // authorities değil roles
    .build();
    }
}