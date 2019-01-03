<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Register</h4>
				</div>

				<div class="panel-body">

					<sf:form method="POST" modelAttribute="supplier" class="form-horizontal">

					<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
									<label for="nameOfEstablishment">Name Of Establishment</label>
										<sf:input path="nameOfEstablishment" class="form-control" placeholder="Name Of Establishment" required="required" />
										<sf:errors path="nameOfEstablishment" cssClass="help-block" element="em"/> 
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="telNo">Contact No.</label>
										<sf:input path="telNo" class="form-control" placeholder="Contact No." required="required" />
										<sf:errors path="telNo" cssClass="help-block" element="em"/> 
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="fax">Fax</label>
										<sf:input path="fax" class="form-control" placeholder="Fax" />
										
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">

								<div class="col-md-12">
									<div class="form-label-group">
										<label for="personInvolved">Authorized Person</label>
										<sf:input path="personInvolved" class="form-control" placeholder="Authorized Person" required="required" />
										<sf:errors path="personInvolved" cssClass="help-block" element="em"/> 
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="position">Position</label>
										<sf:input path="position" class="form-control" placeholder="Position" required="required" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="email">Email</label>
										<sf:input path="email" type="email" class="form-control" placeholder="Email" required="required" />
										<sf:errors path="email" cssClass="help-block" element="em"/> 
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="website">Website</label>
										<sf:input path="website" type="url" class="form-control" placeholder="Website" />
										
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="owner">Name of Owner</label>
										<sf:input path="owner" type="textarea" class="form-control" placeholder="Owner" required="required"/>
										
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="reason">Reason for Application</label>
										<sf:input path="reason" type="textarea" class="form-control" placeholder="Please explain why you need the certification?" required="required"/>
										
									</div>
								</div>
							</div>
						</div>


						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="numOfEmployees">Number of Employees</label>
										<sf:input path="numOfEmployees" type="number" class="form-control" placeholder="Number of Employees" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="productionAreaSize">Production Area Size</label>
										<sf:input path="productionAreaSize" class="form-control" placeholder="Production Area Size" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="indoorArea">Indoor Area</label>
										<sf:input path="indoorArea" class="form-control" placeholder="Indoor Area (m2)" />
										
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-label-group">
										<label for="openArea">Open Area</label>
										<sf:input path="openArea" class="form-control" placeholder="Open Area (m2)" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="numOfRawMaterial"><br>Number of Raw Materials</label>
										<sf:input path="numOfRawMaterial" type="number" class="form-control" />
										
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="numProductsWarehouses">Number of Products in Warehouse(s)</label>
										<sf:input path="numProductsWarehouses" type="number" class="form-control" />
										
									</div>
								</div>
							   </div>
						   </div>
						

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="productionCapacity">Production Capacity</label>
										<sf:input path="productionCapacity" class="form-control" />
										
									</div>
								</div>
							</div>
						</div>
												
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="productionLines">How many production lines are available and their uses(i.e. types, purposes, functionality)</label>
										<sf:input path="productionLines" class="form-control" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="customProduction">Custom Production</label>
										<sf:input path="customProduction" class="form-control" />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="productBrands">Product Brands</label>
										<sf:input path="productBrands" class="form-control" />
										
									</div>
								</div>
							</div>
						</div>
												
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
									<label for="productNotHalal">State products that will not be Halal certified? (If any)</label>
										<sf:input path="productNotHalal" type="textarea" class="form-control"  />
										
									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="namesOfRawMaterials">Names of RawMaterials</label>
										<sf:input path="namesOfRawMaterials" type="textarea" class="form-control"  />
										
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="namesOfSuppliers">Names of Suppliers</label>
										<sf:input path="namesOfSuppliers" type="textarea" class="form-control"  />
										
									</div>
								</div>
							</div>
						</div>
	
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
										<label for="productsProcess">Products Process</label>
										<sf:input path="productsProcess" type="textarea" class="form-control"  />
										
									</div>
								</div>
							</div>
						</div>
																		
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
									<label for="additionalActivities">Any Additional Activities</label>
										<sf:input path="additionalActivities" type="textarea" class="form-control" />
										
									</div>
								</div>
							</div>
						</div>


						<sf:input type="hidden" path="id" />
						
						<button type="submit" name="_eventId_onsite" class="btn btn-lg btn-primary">Next - On Site Address</button>
						
						
					</sf:form>


				</div>


			</div>


		</div>


	</div>


</div>

<%@include file="../flows-shared/footer.jsp"%>
