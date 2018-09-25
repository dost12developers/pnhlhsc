// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	var $tableIngredient = $('#dataTableIngredients');
 
//execute the below code only where we have this table
	if ($tableIngredient.length) {
		//console.log('Inside the table!');

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