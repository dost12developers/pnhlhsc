// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	var $tableCategory = $('#dataTableCategory');
 
//execute the below code only where we have this table
	if ($tableCategory.length) {
		//console.log('Inside the table!');

		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/json/data/all/categories';

		$tableCategory
				.DataTable({

					lengthMenu : [ [ 3, 5, 10 ],
							       [ '3 Records', '5 Records', '10 Records' ] ],
					pageLength : 3,
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
							}]
				});
	}

  
});
