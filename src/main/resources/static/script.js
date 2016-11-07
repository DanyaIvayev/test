/**
 * Created by Дамир on 06.10.2016.
 */
$(document).ready(function(){

    $("#edit").click(function () {
        var values = $('input:checkbox:checked');
        if(values.length==0||values.length>1)
            alert("ВНИМАНИЕ: Для редактирования необходимо выбрать только одну запись.")
        else{
            var pathname = window.location.pathname;
            pathname=pathname.substr(pathname.lastIndexOf("/")+1)
            switch(pathname) {
                case 'displayBranches':
                    var form = $('<form action="edit_branch" method="post">' +
                            '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                            '</form>');
                        $('body').append(form);
                        form.submit();
                    break;
                case 'displayTypes':
                    var form = $('<form action="edit_type" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displayPositions':
                    var form = $('<form action="edit_position" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displayProviders':
                    var form = $('<form action="edit_provider" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displayMedicines':
                    var form = $('<form action="edit_medicine" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displayEmployers':
                    var form = $('<form action="edit_employer" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displaySales':
                    var form = $('<form action="edit_sale" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
                case 'displayBranchProviders':
                    var form = $('<form action="edit_branch_provider" method="post">' +
                        '<input type="hidden" name="editId" value="' + values[0].value + '" />' +
                        '</form>');
                    $('body').append(form);
                    form.submit();
                    break;
            }
        }
    });

    $("#addSave").click(function(e){
        var branch_address = $('#branchAddress').find(":selected").val();
        var medicine_name = $('#medicineName').find(":selected").val();
        var in_stock = $('input[name="inStock"]').val();
        var sold_t = $('input[name="sold"]').val();
        $.ajax({
         type : "POST",
         url : "/index/sale_save",
            data:{
                branchAddress: branch_address,
                medicineName: medicine_name,
                inStock: in_stock,
                sold: sold_t
            },
         timeout : 100000,
         success : function(response) {
             if(response.status == "SUCCESS") {
                 window.location.href = response.result;
             } else {
                 alert(response.result);
                 abort();
             }
         },
         error : function(e) {
                alert('Error: ' + e);
         }
         });
        e.preventDefault();
    })

    $("#brPrSave").click(function(e){
        var branch_address = $('#branchAddress').find(":selected").val();
        var provider_name = $('#providerName').find(":selected").val();
        var day_bilievery = $('#dayOfBilievery').find(":selected").val();
        $.ajax({
            type : "POST",
            url : "/index/branchProvider_save",
            data:{
                branchAddress: branch_address,
                providerName: provider_name,
                dayOfBilievery: day_bilievery

            },
            timeout : 100000,

            success : function(response) {
                if(response.status == "SUCCESS") {
                    window.location.href = response.result;
                } else {
                    alert(response.result);
                    abort();
                }
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        });
        e.preventDefault();
    })
    $("#delete").click(function () {
        var values = $('input:checkbox:checked');
        if(values.length==0)
            alert("ВНИМАНИЕ: Для удаления необходимо выбрать хотя бы одну запись.")
        else{
            var pathname = window.location.pathname;
            pathname=pathname.substr(pathname.lastIndexOf("/")+1)
            //alert(values);
            var a = [];
            for(var i=0; i<values.length; i++){
                a[i]=values[i].value;
            }
                switch(pathname) {
                case 'displayBranches':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_branch",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayTypes':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_type",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayPositions':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_position",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayProviders':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_provider",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayMedicines':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_medicine",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayEmployers':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_employer",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displaySales':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_sale",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
                case 'displayBranchProviders':
                    $.ajax({
                        type : "POST",
                        url : "/index/delete_branch_provider",
                        data : {
                            editIds: a //notice that "myArray" matches the value for @RequestParam
                                       //on the Java side
                        },
                        success : function(response) {
                            location.reload();
                        },
                        error : function(e) {
                            alert('Error: ' + e);
                        }
                    });
                    break;
            }

        }
    });
});