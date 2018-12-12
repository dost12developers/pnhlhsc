<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Register - Confirmation</h4>
				</div>

				<div class="panel-body">

					<div class="text-center">
						<h3><strong>${halalRegisterModel.supplier.nameOfEstablishment}</strong></h3>
						<h4>Name : <strong>${halalRegisterModel.supplier.personInvolved}</strong></h4>
						<h4>Email : <strong>${halalRegisterModel.supplier.email}</strong></h4>
						<h4>Contact : <strong>${halalRegisterModel.supplier.telNo}</strong></h4>
						<h4>Fax : <strong>${halalRegisterModel.supplier.fax}</strong></h4>
						<br/>
						<h5>Fax : <strong>${halalRegisterModel.supplier.owner}</strong></h5>
						<h5>Reason : <strong>${halalRegisterModel.supplier.reason}</strong></h5>
						<h5>Number Of Employees : <strong>${halalRegisterModel.supplier.numOfEmployees}</strong></h5>
						<h5>Production Area Size : <strong>${halalRegisterModel.supplier.productionAreaSize}</strong></h5>
						<h5>IndoorArea : <strong>${halalRegisterModel.supplier.indoorArea}</strong></h5>
						<h5>OpenArea : <strong>${halalRegisterModel.supplier.openArea}</strong></h5>
						<br/><br/>						
						<h4>Address : <strong>${halalRegisterModel.address.address}</strong></h4>
						<h4>City : <strong>${halalRegisterModel.address.city}</strong></h4>
						<h4>Postal Code : <strong>${halalRegisterModel.address.postalCode}</strong></h4>
						
						<br/>
						<p>
							<a  href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">
								Submit
							</a>
						</p>
					</div>


				</div>


			</div>


		</div>


	</div>


</div>

<%@include file="../flows-shared/footer.jsp"%>
