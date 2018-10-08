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
								width: "11%",
								mRender : function(data, type, row) {
									var str = '';
									if(userRole === 'LABORATORY') {
									str += '<a href="'
											+ window.contextRoot
											+ '/laboratory/categories?id='
											+ data
											+ '"><i class="fa fa-pencil">Edit</i></a> | ';
									str += '<a href="'
											+ window.contextRoot
											+ '/laboratory/category/'
											+ data											
											+ '/delete" data-confirm="Are you sure you want to delete?">'
											+ '<i class="fa fa-pencil">Delete</i></a>';
									}
									return str;
								}
							}]

				});
	}

	$tableCategory.on('click', ':not(form)[data-confirm]', function(e){
	    if(!confirm($(this).data('confirm'))){
	      e.stopImmediatePropagation();
	      e.preventDefault();
			}
	});

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

					lengthMenu : [ [  10, 15, 20 ],
							       [ '10 Records', '15 Records', '20 Records' ] ],
					pageLength : 10,
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
							},
							{
								data : 'id',
								bSortable : false,
								width: "11%",
								mRender : function(data, type, row) {
									var str = '';
									if(userRole === 'LABORATORY') {
									str += '<a href="'
											+ window.contextRoot
											+ '/laboratory/product?id='
											+ data
											+ '"><i class="fa fa-pencil">Edit</i></a> | ';
									str += '<a href="'
											+ window.contextRoot
											+ '/laboratory/product/'
											+ data											
											+ '/delete" data-confirm="Are you sure you want to delete?">'
											+ '<i class="fa fa-pencil">Delete</i></a>';
									}
									return str;
								}
							}
							]
				});
	}

	$dataProduct.on('click', ':not(form)[data-confirm]', function(e){
	    if(!confirm($(this).data('confirm'))){
	      e.stopImmediatePropagation();
	      e.preventDefault();
			}
	});
	
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
