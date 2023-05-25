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
    public void addWishlistItem(@RequestParam("customerId") Long customerId, @RequestParam("mutualfundId") Long mutualfundId) {
        wishlistService.insertWishlistItem(customerId, mutualfundId);
    }

    @PostMapping("/remove")
    public void removeWishlistItem(@RequestParam("customerId") Long customerId, @RequestParam("mutualfundId") Long mutualfundId) {
        wishlistService.removeWishlistItem(customerId, mutualfundId);
    }

    @GetMapping("/{customerId}")
    public List<WishlistEntity> getWishlistItemsByCustomerId(@PathVariable("customerId") Long customerId) {
        return wishlistService.findWishlistItemsByCustomerId(customerId);
    }
}
