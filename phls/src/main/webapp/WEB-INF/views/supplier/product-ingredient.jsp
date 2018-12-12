<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
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
		<h4>${product.name}</h4>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
					<th>Ingredient Name</th>
					<security:authorize access="!hasAuthority('SUPPLIER')">
					<th>Type Of Ingredient</th>
					<th>Mark</th>
					<th>Comment</th>
					</security:authorize>
					<th></th>
				</tr>
				<c:forEach items="${ingredientDetails}" var="ingredient">
					<tr>
						<td>${ingredient.ingredient.name}</td>
						<security:authorize access="!hasAuthority('SUPPLIER')">
						<td>
							<c:if test="${ingredient.ingredient.critical}">
								CRITICAL
							</c:if> <c:if test="${not ingredient.ingredient.critical}">
								SAFE
							</c:if>
						</td>
						<td>
							<c:if test="${ingredient.mark}">
							HARAM
							</c:if> <c:if test="${not ingredient.mark}">
							HALAL
							</c:if>
						</td>
						<td>${ingredient.markDescription}</td>
						</security:authorize>
						
						<td>
						<security:authorize access="!hasAuthority('SUPPLIER')">
							<a href="${contextRoot}/supplier/product/${product.id}/ingredients?ingredientDetailId=${ingredient.id}"><i class="fas fa-edit"></i></a>
							|
						</security:authorize>
							<a href="#" data-toggle="modal"
								data-target="#mymodal${ingredient.id}"><i class="fas fa-trash-alt"></i></a>
								
							<div id="mymodal${ingredient.id}" class="modal fade"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">

										<div class="modal-header">
											<h4 class="modal-title">Delete</h4>
											<button type="button" class="close" data-dismiss="modal"aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											
										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete?</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<a href="${contextRoot}/supplier/product/${product.id}/ingredients/${ingredient.id}/delete"
												class="btn btn-danger">Delete</a>
										</div>

									</div>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>

			</table>
			<a href="${contextRoot}/supplier/products"
				class="btn btn-lg btn-primary">Back</a> <a
				href="${contextRoot}/supplier/product/${product.id}/ingredients/add"
				class="btn btn-lg btn-primary">Add</a>

		</div>
	</div>
</div>
