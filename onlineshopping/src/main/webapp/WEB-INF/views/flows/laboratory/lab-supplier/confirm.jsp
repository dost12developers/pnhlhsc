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
				<i class="fas fa-table"></i> Confirmation
			</div>

			<div class="card-body">


				<div class="modal-body">

						${supplierModel.supplier.nameOfEstablishment}<br/>
						${supplierModel.supplier.owner}<br/>
						${supplierModel.supplier.personInvolved}<br/>
						${supplierModel.supplier.telNo}<br/>
						${supplierModel.supplier.fax}<br/>
						${supplierModel.supplier.email}<br/>
						${supplierModel.supplier.website}<br/>
						${supplierModel.supplier.reason}<br/>
						${supplierModel.supplier.numOfEmployees}<br/>
						${supplierModel.supplier.productionAreaSize}<br/>
						${supplierModel.supplier.indoorArea}<br/>
						${supplierModel.supplier.openArea}<br/>
						<br/><br/>
						${supplierModel.address.address}<br/>
						${supplierModel.address.city}<br/>
						${supplierModel.address.postalCode}<br/>
						<br/><br/>
						<a  href="${flowExecutionUrl}&_eventId_supplier" class="btn btn-lg btn-primary">
								Edit Supplier
						</a>

						<a  href="${flowExecutionUrl}&_eventId_address" class="btn btn-lg btn-primary">
								Edit Address
						</a>
						
						<a  href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">
								Save
						</a>
			
				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="../lab-flows-shared/footer.jsp"%>