
<%@page import="java.util.Currency"%>
<%@page import="model.Bean.user"%>
<%@page import= "java.util.List"%>
<%@page import="model.Bean.products"%>
<%@ page import="java.io.*"%>
<%@page import="java.util.Base64"%>
<%@page import ="java.util.stream.Collectors"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>E&E - Electronics eCommerce Bootstrap4 HTML Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.ico">
    
    <!-- CSS
	============================================ -->
   
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    
    <!-- Icon Font CSS -->
    <link rel="stylesheet" href="assets/css/icon-font.min.css">
    
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="assets/css/plugins.css">
    
    <!-- Main Style CSS -->
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/main.css">
    
    <!-- Modernizer JS -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>

<!-- Header Section Start -->
<div class="header-section section">

    <!-- Header Top Start -->
    <div class="header-top header-top-one header-top-border pt-10 pb-10">
        <div class="container">
            <div class="row align-items-center justify-content-between">

                <div class="col mt-10 mb-10">
                    <!-- Header Links Start -->
                    <div class="header-links">
                        <a href="track-order.jsp"><img src="assets/images/icons/car.png" alt="Car Icon"> <span>Track your order</span></a>
                        <a href="store.jsp"><img src="assets/images/icons/marker.png" alt="Car Icon"> <span>Locate Store</span></a>
                    </div><!-- Header Links End -->
                </div>

                <div class="col order-12 order-xs-12 order-lg-2 mt-10 mb-10">
                    <!-- Header Advance Search Start -->
                    <div class="header-advance-search">
                        
                        <form action="#">
                            <div class="input"><input type="text" placeholder="Search your product"></div>
                            <div class="select">
                                <select class="nice-select">
                                    <option>All Categories</option>
                                    <option>Mobile</option>
                                    <option>Computer</option>
                                    <option>Laptop</option>
                                    <option>Camera</option>
                                </select>
                            </div>
                            <div class="submit"><button><i class="icofont icofont-search-alt-1"></i></button></div>
                        </form>
                        
                    </div><!-- Header Advance Search End -->
                </div>

                <div class="col order-2 order-xs-2 order-lg-12 mt-10 mb-10">
                    <!-- Header Account Links Start -->
                    <div class="header-account-links">
                        
                        	<%
								user u = (user)request.getSession().getAttribute("user");
                        		
                        	if (u==null)
							{
                        		System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
								response.sendRedirect("../CheckLoginServlet");	
							
							} else {
								%>
								<a href="inforAccount.jsp"><i class="icofont icofont-user-alt-7"></i> <span>
								<%=u.getUserName()%> <br>
                        </span></a>
                        <a href="myProducts.jsp"><i class="icofont icofont-social-shopify"></i> <span>My Products</span></a>
                        <a href="../CheckLoginServlet"><i class="icofont icofont-login"></i><span>Logout</span></a>
                    </div><!-- Header Account Links End -->
                </div>

            </div>
        </div>
    </div><!-- Header Top End -->

    <!-- Header Bottom Start -->
    <div class="header-bottom header-bottom-one header-sticky">
        <div class="container">
            <div class="row align-items-center justify-content-between">

                <div class="col mt-15 mb-15">
                    <!-- Logo Start -->
                    <div class="header-logo">
                        <a href="index.jsp">
                            <img src="assets/images/logo.png" alt="E&E - Electronics eCommerce Bootstrap4 HTML Template">
                            <img class="theme-dark" src="assets/images/logo-light.png" alt="E&E - Electronics eCommerce Bootstrap4 HTML Template">
                        </a>
                    </div><!-- Logo End -->
                </div>

                <div class="col order-12 order-lg-2 order-xl-2 d-none d-lg-block">
                    <!-- Main Menu Start -->
                    <div class="main-menu">
                        <nav>
                            <ul>
                                <li class="active"><a href="index.jsp">HOME</a></li>
                                <li class="menu-item-has-children"><a href="shop-grid.jsp">Shop</a>
                                    <ul class="sub-menu">
                                        <li class="menu-item-has-children"><a href="shop-grid.jsp">shop grid</a>
                                            <ul class="sub-menu">
                                                <li><a href="shop-grid.jsp">shop grid</a></li>
                                            </ul>
                                        </li>
                                        <li class="menu-item-has-children"><a href="single-product.jsp">Single Product</a>
                                            <ul class="sub-menu">
                                                <li><a href="single-product.jsp">Single Product 1</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children"><a href="#">PAGES</a>
                                    <ul class="mega-menu three-column">
                                        <li><a href="#">Column One</a>
                                            <ul>
                                                <li><a href="about-us.jsp">About us</a></li>
                                                <li><a href="best-deals.jsp">Best Deals</a></li>
                                                <li><a href="../card">Cart</a></li>
                                                <li><a href="checkout.jsp">Checkout</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Column Two</a>
                                            <ul>
                                                <li><a href="compare.jsp">Compare</a></li>
                                                <li><a href="faq.jsp">Faq</a></li>
                                                <li><a href="feature.jsp">Feature</a></li>
                                                <li><a href="login.jsp">Login</a></li>
                                                <li><a href="register.jsp">Register</a></li>
                                                <li><a href="store.jsp">Store</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Column Three</a>
                                            <ul>
                                                <li><a href="terms-conditions.jsp">Terms & Conditions</a></li>
                                                <li><a href="track-order.jsp">Track Order</a></li>
                                                
                                                <li><a href="wishlist.jsp">Wishlist</a></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children"><a href="blog-1-column-left-sidebar.jsp">BLOG</a>
                                    <ul class="sub-menu">
                                        <li><a href="blog-1-column-left-sidebar.jsp">Blog 1 Column Left Sidebar</a></li>
                                        <li><a href="single-blog-left-sidebar.jsp">Single Blog Left Sidebar</a></li>
                                    </ul>
                                </li>
                                <li><a href="contact.jsp">CONTACT</a></li>
                            </ul>
                        </nav>
                    </div><!-- Main Menu End -->
                </div>

                <div class="col order-2 order-lg-12 order-xl-12">
                    <!-- Header Shop Links Start -->
                    <div class="header-shop-links">
                        
                        <!-- Compare -->
                        <a href="compare.jsp" class="header-compare"><i class="ti-control-shuffle"></i></a>
                        <!-- Wishlist -->
                        <a href="wishlist.jsp" class="header-wishlist"><i class="ti-heart"></i> <span class="number">3</span></a>
                        <!-- Cart -->
                        <a href="../card" class="header-cart"><i class="ti-shopping-cart"></i> <span class="number">3</span></a>
                        
                    </div><!-- Header Shop Links End -->
                </div>
                
                <!-- Mobile Menu -->
                <div class="mobile-menu order-12 d-block d-lg-none col"></div>

            </div>
        </div>
    </div><!-- Header Bottom End -->

</div><!-- Header Section End -->

<!-- Mini Cart Wrap Start -->                      
<div class="mini-cart-wrap">

    <!-- Mini Cart Top -->
    <div class="mini-cart-top">    
    
        <button class="close-cart">Close Cart<i class="icofont icofont-close"></i></button>
        
    </div>

    <!-- Mini Cart Products -->
    <ul class="mini-cart-products">
        <li>
            <a class="image"><img src="assets/images/product/product-1.png" alt="Product"></a>
            <div class="content">
                <a href="single-product.jsp" class="title">Waxon Note Book Pro 5</a>
                <span class="price">Price: $295</span>
                <span class="qty">Qty: 02</span>
            </div>
            <button class="remove"><i class="fa fa-trash-o"></i></button>
        </li>
        <li>
            <a class="image"><img src="assets/images/product/product-2.png" alt="Product"></a>
            <div class="content">
                <a href="single-product.jsp" class="title">Aquet Drone D 420</a>
                <span class="price">Price: $275</span>
                <span class="qty">Qty: 01</span>
            </div>
            <button class="remove"><i class="fa fa-trash-o"></i></button>
        </li>
        <li>
            <a class="image"><img src="assets/images/product/product-3.png" alt="Product"></a>
            <div class="content">
                <a href="single-product.jsp" class="title">Game Station X 22</a>
                <span class="price">Price: $295</span>
                <span class="qty">Qty: 01</span>
            </div>
            <button class="remove"><i class="fa fa-trash-o"></i></button>
        </li>
    </ul>

    <!-- Mini Cart Bottom -->
    <div class="mini-cart-bottom">    
    
        <h4 class="sub-total">Total: <span>$1160</span></h4>

        <div class="button">
            <a href="checkout.jsp">CHECK OUT</a>
        </div>
        
    </div>

</div><!-- Mini Cart Wrap End --> 

<!-- Cart Overlay -->
<div class="cart-overlay"></div>

<!-- Page Banner Section Start -->
<div class="page-banner-section section">
    <div class="page-banner-wrap row row-0 d-flex align-items-center ">

        <!-- Page Banner -->
        <div class="col-lg-4 col-12 order-lg-2 d-flex align-items-center justify-content-center">
            <div class="page-banner">
                <h1>My Products</h1>
                <p>similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita</p>
                <div class="breadcrumb">
                    <ul>
                        <li><a href="index.jsp">HOME</a></li>
                        <li><a href="myProducts">My Products</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Banner -->
        <div class="col-lg-4 col-md-6 col-12 order-lg-1">
            <div class="banner"><a href="#"><img src="assets/images/banner-14.jpg" alt="Banner"></a></div>
        </div>

        <!-- Banner -->
        <div class="col-lg-4 col-md-6 col-12 order-lg-3">
            <div class="banner"><a href="#"><img src="assets/images/banner-15.jpg" alt="Banner"></a></div>
        </div>

    </div>
</div><!-- Page Banner Section End -->



<!-- Product Section Start -->
<div class="product-section section mt-90 mb-90">
    <div class="container">
    <button class="createProduct"><a href="createProduct.jsp">Add Product</a></button></br>
        <div class="row">
           
            <div class="col-12">
                
                <div class="row mb-50">
                    <div class="col">
                       
                        <!-- Shop Top Bar Start -->
                        <div class="shop-top-bar">

                            <!-- Product View Mode -->
                            <div class="product-view-mode">
                                <a class="active" href="#" data-target="grid"><i class="fa fa-th"></i></a>
                                <a href="#" data-target="list"><i class="fa fa-list"></i></a>
                            </div>


                            <!-- Product Pages -->
                            <div class="product-pages">
                                <p>Pages 1 of 25</p>
                            </div>

                        </div><!-- Shop Top Bar End -->
                        
                    </div>
                </div>
                
                <!-- Shop Product Wrap Start -->
                <!-- Shop Product Wrap Start -->
                <div class="shop-product-wrap grid row">
                    <%
                        	List<products> listProduct = (List<products>)request.getSession().getAttribute("products");
                        	user user = (user)request.getSession().getAttribute("user");
                        	List<products> MyProduct = listProduct.stream().filter(p->p.getIdUser().equals(user.getIdUser())).collect(Collectors.toList());
                        	byte[] imgData = null;
                        	OutputStream o=null;
                        	for(products pro : MyProduct){
                        		imgData = pro.getImage().getBytes(1,(int)pro.getImage().length());
                        		String imgDataBase64=new String(Base64.getEncoder().encode(imgData));
                                
							%>
							<div class="col-xl-3 col-lg-4 col-md-6 col-12 pb-30 pt-10">                       
                        <!-- Product Start --> 
                        <div class="ee-product">

                            <!-- Image -->
                            <div class="image">

                                <a href="single-product.jsp" class="img"><img src="data:image/gif;base64,<%= imgDataBase64 %>" alt="Product Image"></a>
                            </div>

                            <!-- Content -->
                            <div class="content">

                                <!-- Category & Title -->
                                <div class="category-title">

                                    <a href="#" class="cat"><%=pro.getNameProduct() %></a>
                                    <h5 class="title"><a href="single-product.jsp"><%=pro.getTitle() %></a></h5>

                                </div>

                                <!-- Price & Ratting -->
                                <div class="price-ratting">

                                    <h5 class="price"><%=(double)pro.getPrice()%> $</h5>
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-half-o"></i>
                                        <i class="fa fa-star-o"></i>
                                    </div>
                                    </br> </br>
                                   <div style="display: flex">
                                   <button class="deleteProduct"><a href="../deleteProduct?idProduct=<%=pro.getIdProduct()%>">Delete</a></button>
                                   <button class="UpdateProduct"><a href="../isExistProduct?idProduct=<%=pro.getIdProduct()%>">Update</a></button>
                                   </div>

                                </div>

                            </div>

                        </div><!-- Product End -->
                        
                        <!-- Product List Start -->
                        <div class="ee-product-list">

                            <!-- Image -->
                            <div class="image">

                                <a href="single-product.jsp" class="img"><img src="assets/images/product/product-1.png" alt="Product Image"></a>

                            </div>

                            <!-- Content -->
                            <div class="content">

                                <!-- Category & Title -->
                                <div class="head-content">

                                    <div class="category-title">
                                        <a href="#" class="cat"><%=pro.getNameProduct() %></a>
                                        <h5 class="title"><a href="single-product.jsp"><%=pro.getTitle() %></a></h5>
                                    </div>
                                    
                                    <h5 class="price"><%=pro.getPrice()%> VND</h5>

                                </div>
                                
                                <div class="left-content">
                                   
                                    <div class="ratting">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-half-o"></i>
                                        <i class="fa fa-star-o"></i>
                                    </div>
                                    
                                    <div class="desc">
                                        <p>enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni res eos qui ratione voluptatem sequi nesciunt</p>
                                    </div>
                                    
                                    <div class="actions">

                                        <a href="../add-product-to-card?idProduct=<%=pro.getIdProduct()%>" class="add-to-cart"><i class="ti-shopping-cart"></i><span>ADD TO CART</span></a>

                                        <div class="wishlist-compare">
                                            <a href="#" data-tooltip="Compare"><i class="ti-control-shuffle"></i></a>
                                            <a href="#" data-tooltip="Wishlist"><i class="ti-heart"></i></a>
                                        </div>
                                        
                                    </div>
                                    
                                </div>
                                
                                <div class="right-content">
                                    <div class="specification">
                                        <h5>Specifications</h5>
                                        <ul>
                                            <li>Intel Core i7 Processor</li>
                                            <li>Zeon Z 170 Pro Motherboad</li>
                                            <li>16 GB RAM</li>
                                        </ul>
                                    </div>
                                    <span class="availability">Availability: <span>In Stock</span></span>
                                </div>

                            </div>

                        </div><!-- Product List End -->
                        
                    </div>
							<%
                        	}
                        	}
							%>
                   

                </div><!-- Shop Product Wrap End -->
                
                <div class="row mt-30">
                    <div class="col">

                        <ul class="pagination">
                            <li><a href="#"><i class="fa fa-angle-left"></i>Back</a></li>
                            <li><a href="#">1</a></li>
                            <li class="active"><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li> - - - - - </li>
                            <li><a href="#">18</a></li>
                            <li><a href="#">18</a></li>
                            <li><a href="#">20</a></li>
                            <li><a href="#">Next<i class="fa fa-angle-right"></i></a></li>
                        </ul>
                        
                    </div>
                </div>
                
            </div>
            
        </div>
    </div>
</div><!-- Feature Product Section End -->

<!-- Brands Section Start -->
<div class="brands-section section mb-90">
    <div class="container">
        <div class="row">
            
            <!-- Brand Slider Start -->
            <div class="brand-slider col" style="display: flex">
                <div class="brand-item col"><img src="assets/images/brands/brand-1.png" alt="Brands"></div>
                <div class="brand-item col"><img src="assets/images/brands/brand-2.png" alt="Brands"></div>
                <div class="brand-item col"><img src="assets/images/brands/brand-3.png" alt="Brands"></div>
                <div class="brand-item col"><img src="assets/images/brands/brand-4.png" alt="Brands"></div>
                <div class="brand-item col"><img src="assets/images/brands/brand-5.png" alt="Brands"></div>
            </div><!-- Brand Slider End -->
            
        </div>
    </div>
</div><!-- Brands Section End -->

<!-- Subscribe Section Start -->
<div class="subscribe-section section bg-gray pt-55 pb-55">
    <div class="container">
        <div class="row align-items-center">
            
            <!-- Mailchimp Subscribe Content Start -->
            <div class="col-lg-6 col-12 mb-15 mt-15">
                <div class="subscribe-content">
                    <h2>SUBSCRIBE <span>OUR NEWSLETTER</span></h2>
                    <h2><span>TO GET LATEST</span> PRODUCT UPDATE</h2>
                </div>
            </div><!-- Mailchimp Subscribe Content End -->
            
            
            <!-- Mailchimp Subscribe Form Start -->
            <div class="col-lg-6 col-12 mb-15 mt-15">
                
				<form class="subscribe-form" action="#">
					<input type="email" autocomplete="off" placeholder="Enter your email here" />
					<button >subscribe</button>
				</form>
				<!-- mailchimp-alerts Start -->
				<div class="mailchimp-alerts text-centre">
					<div class="mailchimp-submitting"></div><!-- mailchimp-submitting end -->
					<div class="mailchimp-success"></div><!-- mailchimp-success end -->
					<div class="mailchimp-error"></div><!-- mailchimp-error end -->
				</div><!-- mailchimp-alerts end -->
                
            </div><!-- Mailchimp Subscribe Form End -->
            
        </div>
    </div>
</div><!-- Subscribe Section End -->

<!-- Footer Section Start -->
<div class="footer-section section bg-ivory">
   
    <!-- Footer Top Section Start -->
    <div class="footer-top-section section pt-90 pb-50">
        <div class="container">
            
            <div class="row">
                
                <!-- Footer Widget Start -->
                <div class="col-lg-3 col-md-6 col-12 mb-40">
                    <div class="footer-widget">
                       
                        <h4 class="widget-title">CONTACT INFO</h4>
                        
                        <p class="contact-info">
                            <span>Address</span>
                            You address will be here <br>
                             Lorem Ipsum text                        </p>
                        
                        <p class="contact-info">
                            <span>Phone</span>
                            <a href="tel:01234567890">01234 567 890</a>
                            <a href="tel:01234567891">01234 567 891</a>
                        </p>
                        
                        <p class="contact-info">
                            <span>Web</span>
                            <a href="mailto:info@example.com">info@example.com</a>
                            <a href="#">www.example.com</a>
                        </p>
                        
                    </div>
                </div><!-- Footer Widget End -->
                
                <!-- Footer Widget Start -->
                <div class="col-lg-3 col-md-6 col-12 mb-40">
                    <div class="footer-widget">
                       
                        <h4 class="widget-title">CUSTOMER CARE</h4>
                        
                        <ul class="link-widget">
                            <li><a href="#">About us</a></li>
                            <li><a href="#">Features</a></li>
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Cart</a></li>
                            <li><a href="#">Checkout</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">blog</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                        
                    </div>
                </div><!-- Footer Widget End -->
                
                <!-- Footer Widget Start -->
                <div class="col-lg-3 col-md-6 col-12 mb-40">
                    <div class="footer-widget">
                       
                        <h4 class="widget-title">INFORMATION</h4>
                        
                        <ul class="link-widget">
                            <li><a href="#">Track your order</a></li>
                            <li><a href="#">Locate Store</a></li>
                            <li><a href="#">Online Support</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                            <li><a href="#">Payment</a></li>
                            <li><a href="#">Shipping & Returns</a></li>
                            <li><a href="#">Gift coupon</a></li>
                            <li><a href="#">Special coupon</a></li>
                        </ul>
                        
                    </div>
                </div><!-- Footer Widget End -->
                
                <!-- Footer Widget Start -->
                <div class="col-lg-3 col-md-6 col-12 mb-40">
                    <div class="footer-widget">
                       
                        <h4 class="widget-title">LATEST TWEET</h4>
                        
                        <div class="footer-tweet"></div>
                        
                    </div>
                </div><!-- Footer Widget End -->
                
            </div>
            
        </div>
    </div><!-- Footer Bottom Section Start -->
   
    <!-- Footer Bottom Section Start -->
    <div class="footer-bottom-section section">
        <div class="container">
            <div class="row">
                
                <!-- Footer Copyright -->
                <div class="col-lg-6 col-12">
                    <div class="footer-copyright"><p>&copy; Copyright, 2018 All Rights Reserved by <a href="https://freethemescloud.com/">Free themes Cloud</a></p></div>
                </div>
                
                <!-- Footer Payment Support -->
                <div class="col-lg-6 col-12">
                    <div class="footer-payments-image"><img src="assets/images/payment-support.png" alt="Payment Support Image"></div>
                </div>
                
            </div>
        </div>
    </div><!-- Footer Bottom Section Start -->
    
</div><!-- Footer Section End -->

</body>

</html>