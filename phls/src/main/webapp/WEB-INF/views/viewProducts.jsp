
<div class="container">

	<div class="row">


		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>


					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>


				</div>


			</div>


			<div class="row">

				<div class="col-xs-12">


<div id="hacker-list">
  <ul class="list"></ul>
</div>

<div style="display:none;">
  <!-- A template element is needed when list is empty, TODO: needs a better solution -->
  <li id="hacker-item">
   <h3 class="name"></h3>
   <p class="city"></p>
  </li>
</div>
					<%-- <div class="col-md-3 ">
						<div class="card mb-4 shadow-lg">
							<img class="card-img-top" src="${images}/halalproduct_6.png" alt="" data-holder-rendered="true"
								style="height: 100%; width: 100%; display: block;">
							<div class="card-body">
								<div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">

									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<h5 class="mb-0">
												<h6>
													<center>Passion Guyabano Calamansi Concentrate</center>
												</h6>
												<hr>
												<center>
													<button type="button" class="btn btn-sm btn-success" data-toggle="modal" 
															data-target="#myModal">More Info</button>
												</center>

											
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">
														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>

															</div>
															<div class="modal-body">
																<div class="col-md-12 ">
																	<div class="card mb-2 shadow-lg">
																		<img class="card-img-top" src="${images}/halalproduct_6.png" alt="" 
																			data-holder-rendered="true"
																			style="height: 100%; width: 100%; display: block;">
																		<hr>
																		<h6>
																			<center>Passion Guyabano Calamansi Concentrate</center>
																		</h6>
																		<hr>
																		<h7> Some text in the modal.</h7>
																		<br />
																	</div>

																</div>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-sm btn-info"
																	data-dismiss="modal">Close</button>
															</div>
														</div>

													</div>
												</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>




				
					<div class="col-md-3 ">
						<div class="card mb-4 shadow-lg">
							<img class="card-img-top" src="${images}/halalproduct_1.png"
								alt="" data-holder-rendered="true"
								style="height: 100%; width: 100%; display: block;">
							<div class="card-body">
								<div class="mb-4" id="accordion" role="tablist"
									aria-multiselectable="true">

									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<h5 class="mb-0">
												<h6>
													<center>Muscovado Rocks</center>
												</h6>
												<hr>
												<center>
													<button type="button" class="btn btn-sm btn-success"
														data-toggle="modal" data-target="#myModal">More
														Info</button>
												</center>

												<!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>

															</div>
															<div class="modal-body">
																<p>Some text in the modal.</p>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-sm btn-info"
																	data-dismiss="modal">Close</button>
															</div>
														</div>

													</div>
												</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>




					<div class="col-md-3 ">
						<div class="card mb-4 shadow-lg">
							<img class="card-img-top" src="${images}/halalproduct_1.png"
								alt="" data-holder-rendered="true"
								style="height: 100%; width: 100%; display: block;">
							<div class="card-body">
								<div class="mb-4" id="accordion" role="tablist"
									aria-multiselectable="true">

									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<h5 class="mb-0">
												<h6>
													<center>Muscovado Rocks</center>
												</h6>
												<hr>
												<center>
													<button type="button" class="btn btn-sm btn-success"
														data-toggle="modal" data-target="#myModal">More
														Info</button>
												</center>

												<!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>

															</div>
															<div class="modal-body">
																<p>Some text in the modal.</p>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-sm btn-info"
																	data-dismiss="modal">Close</button>
															</div>
														</div>

													</div>
												</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>


	
					<div class="col-md-3 ">
						<div class="card mb-4 shadow-lg">
							<img class="card-img-top" src="${images}/halalproduct_1.png"
								alt="" data-holder-rendered="true"
								style="height: 100%; width: 100%; display: block;">
							<div class="card-body">
								<div class="mb-4" id="accordion" role="tablist"
									aria-multiselectable="true">

									<div class="card">
										<div class="card-header" role="tab" id="headingTwo">
											<h5 class="mb-0">
												<h6>
													<center>Muscovado Rocks</center>
												</h6>
												<hr>
												<center>
													<button type="button" class="btn btn-sm btn-success"
														data-toggle="modal" data-target="#myModal">More
														Info</button>
												</center>

												<!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>

															</div>
															<div class="modal-body">
																<p>Some text in the modal.</p>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-sm btn-info"
																	data-dismiss="modal">Close</button>
															</div>
														</div>

													</div>
												</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</div>

			</div>


		</div>


 --%>
				</div>






			</div>