$(document).ready(function(){
	
	peticionEstudiantes();
	
	$("#materia").change(peticionEstudiantes);
	$("#grupo").change(peticionEstudiantes);
});

function peticionEstudiantes(){
	
  //peticion ajax para cargar los grupos	
	
	let materia=$("#materia").val();
	let grupo=$("#grupo").val();
	$.ajax({
		method:"Get",
		url:"/grupoestudiantes/reporteEstudiante",
		data:{materia:materia,grupo:grupo},
		success:procesar,
		error:error
	   
	});
}

function procesar(data){
	
	console.log(data);
	
	$("#tdatos").html("");
	  data.forEach(i => {
			$("#tdatos").append(""
					+"<tr>"
						+"<td>"+i.estudiante.nombre+"</td>"
						+"<td></td>"
						+"<td></td>"
					+"</tr>");
	  }); 
	

}

function error(data){}