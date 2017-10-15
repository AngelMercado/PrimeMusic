var cartApp = angular.module('cartApp',[]);

cartApp.controller("cartCtrl",function($scope,$http){	
	
	$scope.refreshCart = function(){		
		$http.get("/primeMusic/rest/cart/"+$scope.cartId).success(function(data){
			$scope.cart=data;
			console.log(data);
		});
	};
	
	$scope.clearCart = function(){		
		$http.delete("/primeMusic/rest/cart/"+$scope.cartId).success(function(data){
			$scope.refreshCart();
		});
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;	
		$scope.refreshCart();
		
	};
	$scope.addToCart = function(productId){
		$http.put("/primeMusic/rest/cart/add/"+productId).success(function(){		
			alert("Product succesfully added to the cart");
		});
	};
	
	$scope.removeFromCart = function(productId){
		
		$http.put("/primeMusic/rest/cart/remove/"+productId).success(function(data){			
			alert("eliminado "+productId);
		});
		
	};
	
	$scope.calGrandTotal = function(){
		var grandTotal = 0;
		
		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	};
});