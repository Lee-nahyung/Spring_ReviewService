package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    //맛집 리스트 가져오기 API
    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "This is getRestaurants";
    }

    //맛집 정보 가져오기 API
    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is getRestaurant" + restaurantId;
    }

    //맛집 생성 API
    @PostMapping("/restaurant")
    public String createRestaurant(){
        return "This is createRestaurant";
    }

    //맛집 수정 API
    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is editRestaurant" + restaurantId;
    }

    //맛집 삭제 API
    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is deleteRestaurant" + restaurantId;
    }


}
