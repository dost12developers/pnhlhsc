
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<c:if test="${not empty message}">
	<div class="alert alert-success">${message}</div>
</c:if>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient
	</div>

	<div class="card-body">
		<h4>Company : <strong>${product.supplier.nameOfEstablishment}</strong></h4>
		<h4>Product : <strong>${product.name}</strong></h4>
		<h4>Ingredient : </h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Mark</th>
					<th></th>
					<th>Comment</th>
					<th></th>
				</tr>
				<c:forEach items="${ingredientDetails}" var="ingredient">
					<tr>
						<td>${ingredient.ingredient.name}</td>
						<td>${ingredient.ingredient.description}</td>
						<td><c:if test="${ingredient.ingredient.critical}">
							Critical
						</c:if> <c:if test="${not ingredient.ingredient.critical}">
							Safe
						</c:if></td>
						<td><c:if test="${ingredient.mark}">
							None conform to H. Standards
						</c:if> <c:if test="${not ingredient.mark}">
							Conform to H. Standards
						</c:if></td>
						<td>${ingredient.markDescription}</td>
						<td><a
							href="${contextRoot}/laboratory/product/${product.id}/ingredients?ingredientDetailId=${ingredient.id}"><i
								class="fas fa-edit"></i></a> | <a href="#" data-toggle="modal"
							data-target="#mymodal${ingredient.id}"><i
								class="fas fa-trash-alt"></i></a>

							<div id="mymodal${ingredient.id}" class="modal fade"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Delete</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>

										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<a
												href="${contextRoot}/laboratory/product/${product.id}/ingredients/${ingredient.id}/delete"
												class="btn btn-danger">Delete</a>
										</div>

									</div>
								</div>
							</div></td>
					</tr>
				</c:forEach>

			</table>
			<a href="${contextRoot}/laboratory/products"
				class="btn btn-lg btn-primary">Back</a> <a
				href="${contextRoot}/laboratory/product/${product.id}/ingredients/add"
				class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
