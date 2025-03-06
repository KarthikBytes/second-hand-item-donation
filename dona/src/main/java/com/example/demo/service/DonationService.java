package com.example.demo.service;

package com.example.demo.service;

import com.sharecare.dto.DonationDTO;
import com.sharecare.entity.Donation;
import com.sharecare.repository.DonationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void donateItem(DonationDTO dto) {
        Donation donation = new Donation();
        donation.setItemName(dto.getItemName());
        donation.setCategory(dto.getCategory());
        donation.setDescription(dto.getDescription());
        
        // Get the logged-in user’s email
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            donation.setDonorEmail(userDetails.getUsername());
        }

        donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public List<Donation> getUserDonations(String email) {
        return donationRepository.findByDonorEmail(email);
    }
}
