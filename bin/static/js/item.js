
$(function() {
  getCategoryList();

  $('#catgory-btn').click(function() {
    getCategoryList();
  });
});

function getCategoryList() {
  $('.onecategory').remove();
  $('.oneitem').remove();
  $('#loader-category').show();

  $.getJSON('shouhinbunruilist', function(data) {
    console.log('category.size=' + data.length);

    $.each(data, function(i, item) {
      $('table#categorys').append('<tr class="onecategory"><td id="' + item.shouhinbunruiId + '">' + item.name + '</td></tr>');
    });

    $('table#categorys').find('tr').click(function() {
      getShouhinList($(this).find('td').attr("id"));
    });

    $('#loader-category').hide();
    $('#loader-item').hide();
  });
}

function getShouhinList(shouhinbunruiId) {
  console.log('shouhinbunruiId=' + shouhinbunruiId);

  $('.oneitem').remove();
  $('#loader-item').show();

  $.getJSON('shouhin/shouhinbunruiId='+ shouhinbunruiId, function(data) {
    console.log('item.size' + data.length);
    $.each(data, function(i, item) {
      $('table#items').append('<tr class="oneitem">' 
        + '<td>' + item.shouhinId + '</td>' 
        + '<td>' + item.shouhin + '</td>'
        + '<td>' + item.urine + '</td>'
        + '<td>' + item.seisanchi + '</td>'
        + '</tr>');
    });
    $('#loader-item').hide();
  });
}
