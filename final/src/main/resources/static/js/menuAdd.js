var num = 0;
$(function(){
    $("#insert").click(function(){
           num ++;
           $('#addMenu').append('<tr id="list_'+num+'" align="left" valign="left" >'+
        		   '<td class="k"   align=left   ><textarea name="fieldType" class="autosize" onkeydown="resize(this)" onkeyup="resize(this)">'+
        		   '</textarea></td>'+
        		   '<td class="k"  align=left> <textarea name="reqCareer" class="autosize" onkeydown="resize(this)" onkeyup="resize(this)"></textarea></td>'+
        		   '<td colspan="2" class="k" align=center ><textarea name="workType" class="autosize" onkeydown="resize(this)" onkeyup="resize(this)"> </textarea></td>'+
        		   '<td colspan="2" class="k" align=left > <textarea name="qualifi" class="autosize" onkeydown="resize(this)" onkeyup="resize(this)">'+
        		   '</textarea><button type="button" onclick="delElement('+num+');">삭제</button> </td></tr>');    
                 


    });

});

function delElement(num){
    $("#list_"+num).remove();
}