package com.wishlist.mf.controller;

import com.wishlist.mf.entity.WishlistEntity;
import com.wishlist.mf.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping("/add")
    public String addWishlistItem(@RequestParam("customerId") Long customerId, @RequestParam("mutualfundId") Long mutualfundId) {
        wishlistService.insertWishlistItem(customerId, mutualfundId);
        return "Data added successfully";
    }

    @PostMapping("/remove")
    public String removeWishlistItem(@RequestParam("customerId") Long customerId, @RequestParam("mutualfundId") Long mutualfundId) {
        wishlistService.removeWishlistItem(customerId, mutualfundId);
        return "Data removed successfully";
    }

    @GetMapping("/{customerId}")
    public List<WishlistEntity> getWishlistItemsByCustomerId(@PathVariable("customerId") Long customerId) {
        return wishlistService.findWishlistItemsByCustomerId(customerId);
    }
}
