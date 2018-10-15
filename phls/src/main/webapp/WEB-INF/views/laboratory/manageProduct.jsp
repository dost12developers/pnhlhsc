  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/laboratory/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Product</li>
          </ol>

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Products</div>
            <div class="card-body">
            <a class="btn btn-primary" href="${contextRoot}/laboratory/lab-product">Add New Product</a><br><br>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTableProductId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
					    <th></th>
					    <th>ID</th>
					    <th>Name</th>
					    <th>Code</th>
					    <th>Description</th>
					    <th></th>
					    <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
					    <th></th>
					    <th>ID</th>
					    <th>Name</th>
					    <th>Code</th>
					    <th>Description</th>
					    <th></th>
					    <th></th>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>