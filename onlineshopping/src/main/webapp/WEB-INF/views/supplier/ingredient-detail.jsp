<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/supplier/">Dashboard</a></li>
	<li class="breadcrumb-item active">Ingredient</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> Ingredient
	</div>

	<div class="card-body">
		<sf:form class="form-horizontal" modelAttribute="ingredientDetail"
			action="${contextRoot}/supplier/product/${product.id}/ingredients/ingredient" method="POST" enctype="multipart/form-data">
			        
			<div class="modal-body">
				<table>

					<c:if test="${ingredient == null}">
					<tr>
						<td><sf:label path="ingredientId" class="control-label">Ingredient Name</sf:label></td>
						<td><sf:select path="ingredientId" items="${ingredients}" itemLabel="name" itemValue="id" class="form-control"/>
						</td>
					</tr>
					</c:if>
					
					<c:if test="${ingredient != null }">
					
					<tr>
						<td><label>Ingredient Name</label></td>
						<td><label> <b>${ingredient.name}</b> </label>
							<sf:input type="hidden" path="ingredientId" value="${ingredient.id}"/>
						</td>
					</tr>
					</c:if>
					<security:authorize access="!hasAuthority('SUPPLIER')">
					<tr>
						<td><sf:label path="mark" class="control-label">Mark</sf:label></td>
						<td><sf:radiobutton path="mark" value="false" checked="checked"/> Halal
							<sf:radiobutton path="mark" value="true"/> Haram
						</td>
					</tr>
					<tr>
						<td><sf:label path="markDescription" class="control-label">Comment</sf:label></td>
						<td><sf:input path="markDescription" class="form-control" placeholder="Mark Comment" /></td>
					</tr>					
					</security:authorize>
					<security:authorize access="hasAuthority('SUPPLIER')">
						<sf:hidden path="mark" value="false" />
						<sf:hidden path="markDescription" value="" />
					</security:authorize>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<sf:input type="hidden" path="id" />
						<td>
							<a href="${contextRoot}/supplier/product/${product.id}/ingredients" class="btn btn-secondary">Cancel</a>&nbsp;&nbsp;
							<input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</table>
			</div>
		</sf:form>

	</div>
</div>
