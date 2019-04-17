$(function () {
  var loadFlag = false
  $('a.social-icon.search').on('click', function () {
    $('body').css('width', '100%')
    $('body').css('overflow', 'hidden')
    $('.search-dialog').velocity('stop')
      .velocity('transition.expandIn', {
        duration: 300,
        complete: function () {
          $('#local-search-input input').focus()
        }
      })
    $('.search-mask').velocity('stop')
      .velocity('transition.fadeIn', {
        duration: 300
      })
    // shortcut: ESC
    document.addEventListener('keydown', function f(event) {
      if (event.code === 'Escape') {
        closeSearch()
        document.removeEventListener('keydown', f)
      }
    })
  })
   
  
  var closeSearch = function () {
    $('body').css('overflow', 'auto')
    $('.search-dialog').velocity('stop')
      .velocity('transition.expandOut', {
        duration: 300
      })
    $('.search-mask').velocity('stop')
      .velocity('transition.fadeOut', {
        duration: 300
      })
  }
  $('.search-mask, .search-close-button').on('click', closeSearch)


})

  