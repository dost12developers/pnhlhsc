<%@include file="../lab-flows-shared/header.jsp"%>


<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!-- Breadcrumbs-->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="${contextRoot}/laboratory/">Dashboard</a></li>
	<li class="breadcrumb-item active">Company</li>
</ol>

<!-- DataTables -->
<div class="card mb-3">

	<div class="container">

		<div class="card card-register mx-auto mt-5">

			<div class="card-header">
				<i class="fas fa-table"></i> Company
			</div>

			<div class="card-body">


				<div class="modal-body">
					<sf:form class="form-horizontal" modelAttribute="supplier"
						method="POST">

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="nameOfEstablishment" class="form-control" placeholder="Company Name" required="required" />
										<label for="nameOfEstablishment">Company Name</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="nameOfEstablishment" class="form-control" placeholder="Company Address" required="required" />
										<label for="nameOfEstablishment">Company Address</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<sf:input path="telNo" class="form-control" placeholder="Contact No." required="required" />
										<label for="telNo">Contact No.</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-label-group">
										<sf:input path="fax" class="form-control" placeholder="Fax" />
										<label for="fax">Fax</label>
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">

								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="personInvolved" class="form-control" placeholder="Authorized Person" required="required" />
										<label for="personInvolved">Authorized Person</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="position" class="form-control" placeholder="Position" required="required" />
										<label for="position">Position</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="email" type="email" class="form-control" placeholder="Email" required="required" />
										<label for="email">Email</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="website" class="form-control" placeholder="http://XXXXXX.com" />
										<label for="website">Website</label>
									</div>
								</div>
							</div>
						</div>





						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="reason" type="textarea" class="form-control" placeholder="Please explain why you need the certification?" />
										<label for="reason">Reason for Application</label>
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="numOfEmployees" class="form-control" placeholder="Number of Employees" />
										<label for="numOfEmployees">Number of Employees</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productionAreaSize" class="form-control" placeholder="Production Area Size" />
										<label for="productionAreaSize">Production Area Size</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<sf:input path="indoorArea" class="form-control" placeholder="Indoor Area (m2)" />
										<label for="indoorArea">Indoor Area (m2)</label>
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-label-group">
										<sf:input path="openArea" class="form-control" placeholder="Open Area (m2)" />
										<label for="openArea">Open Area (m2)</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="numOfRawMaterial" class="form-control" />
										<label for="numOfRawMaterial">Number of Raw Material Warehouses</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="numProductsWarehouses" class="form-control" />
										<label for="numProductsWarehouses">Number of Finished Products Warehouses</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productionCapacity" class="form-control" />
										<label for="productionCapacity">Production Capacity (TON/YEAR)</label>
									</div>
								</div>
							</div>
						</div>
												
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productionLines" class="form-control" />
										<label for="productionLines">How many production lines are available and their uses(i.e. types, purposes, functionality)</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="customProduction" class="form-control" />
										<label for="customProduction">Does company do custom production(like private label)</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productBrands" class="form-control" />
										<label for="productBrands">Brands of Products</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productVarieties" class="form-control" />
										<label for="productVarieties">Product Varieties</label>
									</div>
								</div>
							</div>
						</div>											
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productNotHalal" type="textarea" class="form-control"  />
										<label for="productNotHalal">State products that will not be Halal certified? (If any)</label>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="namesOfRawMaterials" type="textarea" class="form-control"  />
										<label for="namesOfRawMaterials">Names of Raw Materials</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="namesOfSuppliers" type="textarea" class="form-control"  />
										<label for="namesOfSuppliers">Names of Suppliers</label>
									</div>
								</div>
							</div>
						</div>
	
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<sf:input path="productsProcess" type="textarea" class="form-control"  />
										<label for="productsProcess">Products Process</label>
									</div>
								</div>
							</div>
						</div>
																		



						<sf:input type="hidden" path="id" />

						<button type="submit" name="_eventId_onsite" class="btn btn-lg btn-primary">Next - Assessment</button>


					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="../lab-flows-shared/footer.jsp"%>