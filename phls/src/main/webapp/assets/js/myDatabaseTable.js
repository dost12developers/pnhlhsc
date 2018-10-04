// Call the dataTables jQuery plugin
$(document).ready(function() {

	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	var $tableCategory = $('#dataTableCategory');
 
	if ($tableCategory.length) {
		var jsonUrl = '';            
		jsonUrl = window.contextRoot + '/json/lab/data/all/categories';
		$tableCategory
				.DataTable({

					lengthMenu : [ [  10, 15, 20 ],
							       [ '10 Records', '15 Records', '20 Records' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'name'
							},
							{
								data : 'description'
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									if(userRole === 'LABORATORY') {
									str += '<a href="'
											+ window.contextRoot
											+ '/laboratory/category?id='
											+ data
											+ '" class="btn btn-warning"><i class="fas fa-fw fa-edit"></i></a> &#160;';

								
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-danger"><i class="fas fa-fw fa-exclamation-circle"></i></a>';
									}
									
									return str;
								}
							}]
				});
	}

	
	
	var $dataCertification = $('#dataTableCertificationId');
	if ($dataCertification.length) {
		var jsonUrl = '';            
		jsonUrl = window.contextRoot + '/json/lab/data/all/certifications';
		$dataCertification
				.DataTable({

					lengthMenu : [ [  10, 15, 20 ],
							       [ '10 Records', '15 Records', '20 Records' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id',
							},
							{
								data : 'title'
							},
							{
								data : 'description'
							},
							{
								data : 'local',
								mRender : function(data, type, row) {
									if( data == true )
										return 'Local';
									else
										return'International';
								}
							 }
							]
				});
	}
 
	var $tableIngredient = $('#dataTableIngredientsId');
	if ($tableIngredient.length) {
		var jsonUrl = '';
			jsonUrl = window.contextRoot + '/json/lab/data/all/ingredients';

			$tableIngredient
					.DataTable({

						lengthMenu : [ [  10, 15, 20 ],
								       [ '10 Records', '15 Records', '20 Records' ] ],
						pageLength : 10,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
								{
									data : 'id',
								},
								{
									data : 'name'
								},
								{
									data : 'description'
								},
								{
									data : 'mark'
								}]
					});
		}
    
	var $dataProduct = $('#dataTableProductId');
	if ($dataProduct.length) {
		var jsonUrl = '';            
		jsonUrl = window.contextRoot + '/json/lab/data/all/products';
		$dataProduct
				.DataTable({

					lengthMenu : [ [  5, 15, 20 ],
							       [ '10 Records', '15 Records', '20 Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
	
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.png" class="dataTableImg"/>';
	
								}								
							},							
							{
								data : 'id'
							},
						
							{
								data : 'name'
							},
							{
								data : 'code'
	
							},	
							{
								data : 'description'
							},
							{
								data : 'weight'
							 },
							{
								data : 'ingredients'
							},
							{
								data : 'certifications'
							}
							]
				});
	}

	var $dataManufacture = $('#dataTableManufactureId');
	if ($dataManufacture.length) {
		var jsonUrl = '';            
		jsonUrl = window.contextRoot + '/json/lab/data/all/manufacatures';
		$dataManufacture
				.DataTable({

					lengthMenu : [ [  10, 15, 20 ],
							       [ '10 Records', '15 Records', '20 Records' ] ],
					pageLength : 10,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id',
							},
							{
								data : 'name'
							},
							{
								data : 'telNo'
							},
							{
								data : 'website'
							 }
							]
				});
	}
	



});
