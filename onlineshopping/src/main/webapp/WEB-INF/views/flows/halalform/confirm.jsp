<%@include file="../flows-shared/header.jsp"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Confirmation</h4>
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
							<a  href="${flowExecutionUrl}&_eventId_supplier" class="btn btn-lg btn-default">
								Edit Supplier
							</a>
							
							<a  href="${flowExecutionUrl}&_eventId_address" class="btn btn-lg btn-default">
								Edit On site Address
							</a>

						</p>
					</div>


				</div>


			</div>


		</div>
		</div>
		<div class="row">
		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Terms and Conditions</h4>
				</div>

				<div class="panel-body">

					<div class="text-center">
						
I HEREBY STATE THAT THE INFORMATION GIVEN ABOVE IS CORRECT AND CAN BE VERIFIED BY RECORDS. 
I KINDLY ASK YOU TO REVIEW THIS INFORMATION AND ADVISE US PROCEDURES FOR USE OF THE DOST XII SEAL OF QUALITY LOGO. 
I UNDERSTAND THAT DOST XII  HAS THE RIGHT TO ACCEPT OR REJECT OUR APPLICATION AND THAT IN CASE OF REFUSAL, IT IS FREE TO GIVE REASONS FOR THE REFUSAL. 
						
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
