  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/supplier/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Company</li>
          </ol>
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Suppliers</div>
            <div class="card-body">
              <div class="table-responsive">
              <a class="btn btn-primary" style="float: left" href="${contextRoot}/supplier/lab-supplier"><i class="fas fa-plus-square"></i></a>
                <table class="table table-bordered" id="dataTableSupplierId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>CreatedOn</th>
                      <th>UpdatedOn</th>                              
                      <th>Name</th>
                      <th>Authorized Person</th>
                      <th>Position</th>                      
                      <th>Telephone No.</th>
                      <th>Email</th>                     
                      <th>Products</th>
                      <th>UpdatedBy</th>
                   	  <th></th>
                   	  <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>CreatedOn</th>
                      <th>UpdatedOn</th>                              
                      <th>Name</th>
                      <th>Authorized Person</th>
                      <th>Position</th>                      
                      <th>Telephone No.</th>
                      <th>Email</th>                     
                      <th>Products</th>
                      <th>UpdatedBy</th>
                   	  <th></th>
                   	  <th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          
          
          					