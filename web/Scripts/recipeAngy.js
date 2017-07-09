/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module("myApp", []);

app.controller("myCtrl", function($scope) {
    $scope.categories_images = [];
    
    $scope.categories_images.push({
    src: "../Images/Categories/Fruits.png",
        alt: "test"
    });
    
        $scope.categories_images.push({
        src: "../Images/Categories/Fruits.png",
        alt: "test"
    });
    
        $scope.categories_images.push({
        src: "../Images/Categories/Fruits.png",
        alt: "test"
    });
    
});