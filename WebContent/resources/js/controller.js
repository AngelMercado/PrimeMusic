var cartApp = angular.module('cartApp',[]);

cartApp.controller("cartCtrl",function($scope,$http){	
	
	$scope.refreshCart = function(cartId){
		$scope.cartId = cartId;
		$http.get("/primeMusic/rest/cart/"+$scope.cartId).success(function(data){
			$scope.cart=data;
			console.log(data);
		});
	};
	
	$scope.clearCart = function(){		
		$http.delete("/primeMusic/rest/cart/"+$scope.cartId).success(function(data){
			$scope.refreshCart($scope.cardId);
		});
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;	
		$scope.refreshCart(cartId);
		
	};
	$scope.addToCart = function(productId){
		$http.put("/primeMusic/rest/cart/add/"+productId).success(function(data){
			$scope.refreshCart($http.get("/primeMusic/rest/cart/cartId"));
			alert("Product succesfully added to the cart");
		});
	};
	
	$scope.removeFromCart = function(productId){
		
		$http.put("/primeMusic/rest/cart/remove/"+productId).success(function(data){
			$scope.refreshCart($http.get("/primeMusic/rest/cart/cartId"));
			alert("eliminado "+productId);
		});
		
	};
});