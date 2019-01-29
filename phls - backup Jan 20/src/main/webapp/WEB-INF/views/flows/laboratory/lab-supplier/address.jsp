<%@include file="../lab-flows-shared/header.jsp"%>


<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Supplier</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">

	<div class="container">

		<div class="card card-register mx-auto mt-5">

			<div class="card-header">
				<i class="fas fa-table"></i> Address
			</div>
			<div class="card-body">
				
			</div>
			<div class="card-body">


				<div class="modal-body">
					<sf:form class="form-horizontal" modelAttribute="onsite"  method="POST">

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="addressLineOne" type="text" class="form-control" placeholder="Address Line 1" required="required"/>
										<label for="addressLineOne">Address Line 1</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="addressLineTwo" type="text" class="form-control" placeholder="Address Line 2" />
										<label for="addressLineTwo">Address Line 2</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="city" type="text" class="form-control" placeholder="City" required="required"/>
										<label for="city">City</label>
									</div>
								</div>
							</div>
						</div>
		
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="state" type="text" class="form-control" placeholder="State" required="required"/>
										<label for="state">State</label>
									</div>
								</div>
							</div>
						</div>
	
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="postalCode" type="text" class="form-control" placeholder="Postal Code" required="required"/>
										<label for="postalCode">Postal Code</label>
									</div>
								</div>
							</div>
						</div>	
																							
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="country" type="text" class="form-control" placeholder="Country" required="required"/>
										<label for="country">Country</label>
									</div>
								</div>
							</div>
						</div>						
									
						<sf:input type="hidden" path="onsite" value="true"/>
							
						<sf:input type="hidden" path="id" />


						<button type="submit" name="_eventId_confirm" class="btn btn-lg btn-primary">
								Next - confirm
						</button>
										

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="../lab-flows-shared/footer.jsp"%>