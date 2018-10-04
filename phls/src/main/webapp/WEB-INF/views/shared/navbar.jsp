<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<script>
		window.userRole = '${userModel.role}';
	</script>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="navbar-brand">
               		 <a href="http://www.gov.ph">GOVPH</a>
                </div>
                <div class="navbar-brand">
            	   <a href="${contextRoot}/home"><img src="${images}/logo.png" width="32"  alt=""></a>
          		</div>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                     <li id="listProducts">
                        <a href="${contextRoot}/show/all/products">View Products</a>
                    </li>               
                     <li id="services" class="dropdown">
			            <a href="${contextRoot}/home" class="dropdown-toggle" data-toggle="dropdown" role="button" >Our Halal Services</a>
			            <ul class="dropdown-menu">
			               <li><i>&nbsp;&nbsp;Halal Laboratory Services:</i></li>
			                <li><a href="${contextRoot}/servicesLabTesting">&nbsp;&nbsp;Testing and Verification</a></li>
			                <li><a href="${contextRoot}/servicesLabOnSite">&nbsp;&nbsp;On-Site Assessment and Product Certification</a></li>
			               <li role="separator" class="divider"></li>
			               <li><i>&nbsp;&nbsp;Other Services:</i></li>
			               <li><a href="${contextRoot}/servicesFoodDevelopment">&nbsp;&nbsp;Halal Food Developement/Training</a></li>
			               <li><a href="${contextRoot}/servicesResearch">&nbsp;&nbsp;Halal Research and Development</a></li>
			               <li><a href="${contextRoot}/servicesPackageLabel">&nbsp;&nbsp;Halal Packaging and Labeling</a></li>
			          </ul>
			        </li>

                     <li id="multimedia">
                        <a href="${contextRoot}/multimedia">View Multimedia</a>
                    </li>
                     <li id="contact">
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                    <li id="about">
                        <a href="${contextRoot}/about">About Us</a>
                    </li>                                                           
<%-- 					<security:authorize access="hasAuthority('ADMIN')">
	                    <li id="manageProduct">
	                        <a href="${contextRoot}/manage/product">Manage Product</a>
	                    </li>					
					</security:authorize> --%>
                </ul>
			    
			    <ul class="nav navbar-nav navbar-right">
			    	<security:authorize access="isAnonymous()">
	                    <li id="signup">
	                        <a href="${contextRoot}/membership">Sign Up</a>
	                    </li>
						<li id="login">
	                        <a href="${contextRoot}/login">Login</a>
	                    </li> 			    	
			    	</security:authorize>
			    	<security:authorize access="isAuthenticated()">
						<li class="dropdown" id="userModel">
						  <a class="btn btn-default dropdown-toggle" href="javascript:void(0)" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						    ${userModel.fullName}
						    <span class="caret"></span>
						  </a>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		                    <security:authorize access="hasAuthority('USER')">
			                    <li id="cart">
			                        <a href="${contextRoot}/cart/show">
			                        	<span class="glyphicon glyphicon-shopping-cart"></span>&#160;<span class="badge">${userModel.cart.cartLines}</span> - &#8377; ${userModel.cart.grandTotal} 
			                        </a>
			                    </li>		     
			                	<li role="separator" class="divider"></li>	                                   
		                    </security:authorize>
							<li id="logout">
		                        <a href="${contextRoot}/logout">Logout</a>
		                    </li>                    			    	
						  </ul>		
						</li>    			    
			    	</security:authorize>                    
			    </ul>                
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

