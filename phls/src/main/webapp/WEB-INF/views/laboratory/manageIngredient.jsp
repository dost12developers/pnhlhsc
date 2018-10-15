  <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
  <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="${contextRoot}/laboratory/">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Ingredient</li>
          </ol>

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              List of Source Ingredients</div>
            <div class="card-body">
             <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalIngredientId">Add New Ingredient</button><br><br>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTableIngredientsId" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Description</th>
                      <th>Mark</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Description</th>
                      <th>Mark</th>
                    </tr>
                  </tfoot>
                 </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
          
 <!-- Modal -->
<div class="modal fade" id="modalIngredientId" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Ingredient</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			
			<sf:form  class="form-horizontal" modelAttribute="ingredient"  action="${contextRoot}/laboratory-admin/ingredient" method="POST">
				<div class="modal-body">

       			<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control" placeholder="Ingredient Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div> 
				<div class="form-group">
				<label class="control-label col-md-4">Mark Ingredient</label>
				<div class="col-md-8">
					<label class="radio-inline">
						<sf:radiobutton path="critical" value="false" checked="checked"/> None Critical  				
					</label>
					<label class="radio-inline">
						<sf:radiobutton path="critical" value="true"/>&nbsp;Critical
					</label>
				</div>
			</div>								  				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					 <button type="Submit" class="btn btn-primary">Save</button>
				</div>
			</sf:form>
		</div>
	</div>
</div>         