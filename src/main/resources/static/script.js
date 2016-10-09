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
            }
        }

    });
});