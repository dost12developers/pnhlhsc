<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Register - On Site Assessment</h4>
				</div>

				<div class="panel-body">

					<sf:form method="POST" modelAttribute="onsite" class="form-horizontal">

					<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<div class="form-label-group">
									<label for="address">Address</label>
										<sf:input path="address" class="form-control" placeholder="Address" required="required" />									
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="city">City</label>
										<sf:input path="city" class="form-control" placeholder="City" required="required" />
										
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-label-group">
										<label for="postalCode">Postal Code</label>
										<sf:input path="postalCode" class="form-control" placeholder="Postal Code" />										
									</div>
								</div>
							</div>
						</div>

						<sf:input type="hidden" path="id" />
						<button type="submit" name="_eventId_confirm" class="btn btn-lg btn-primary">Next - Confirmation</button>
						
					</sf:form>


				</div>


			</div>


		</div>


	</div>


</div>

<%@include file="../flows-shared/footer.jsp"%>
