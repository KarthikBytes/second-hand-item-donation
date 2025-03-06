package com.example.demo.repository;
import com.exaple.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByDonorEmail(String email);
}
