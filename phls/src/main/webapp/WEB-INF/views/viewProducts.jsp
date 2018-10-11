
<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>


					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>


				</div>


			</div>


			<div class="row">

				<div class="col-xs-12">

					<div id="halal-item">
						<div class="row">
							<div class="col-md-4">
								<input type="text" class="fuzzy-search form-control" placeholder="Search for product name or code"/>
							</div>
							<div class="col-md-6">
							</div>
							<div class="col-md-2">
								<button class="sort btn btn-default" data-sort="name">Sort by name</button>
							</div>
						</div>
						<div class="row">				
							<ul id="myproductsid" class="list list-group"></ul>
						</div>
						<div class="row">
						<div class="col-md-5">
						</div>
						<div class="col-md-6">
							<ul class="pagination"></ul>
						</div>
						</div>
					</div>

				</div>

			</div>