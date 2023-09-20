package com.ashokbaniya.connection;

public class SellFarmerCrops {
        public String name;
        public int price ;
        public int total_crops;

        public SellFarmerCrops() {
            // Default constructor required for DataSnapshot.getValue(User.class)
        }

        public SellFarmerCrops(String name,int price, int total_crops) {
            this.name = name;
            this.price =price ;
            this.total_crops =total_crops;

        }
    }

