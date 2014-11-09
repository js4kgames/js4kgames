[#ftl]

[#macro page]
<!DOCTYPE html>
<html>
  <head>
    <title>js4kgames - JavaScript 4K Game Competition</title>
    <link rel="stylesheet" type="text/css" href="/css/js4kgames.css">
  </head>
  <body>
    <div id="wrap">
      <div id="header">       
        <h1 id="logo">js<span class="green">4k</span>games<span class="gray">.appspot.com</span></h1>  
        <h2 id="slogan">JavaScript Game Competition in just 4 KB</h2>
        <form id="quick-search" method="get" class="searchform" action="/search">
          <p>
            <input class="textbox" id="search" type="text" name="qsearch" placeholder="Search for games...">
            <input type="submit" name="search" class="button" value="Search">
          </p>
        </form>
        <ul>
          <li[#if (menuSelection!'') == 'home'] id="current"[/#if]><a href="/"><span>Home</span></a></li>
          <li[#if (menuSelection!'') == 'entries'] id="current"[/#if]><a href="/games"><span>Entries</span></a></li>
          <li[#if (menuSelection!'') == 'rules'] id="current"[/#if]><a href="/rules"><span>Rules</span></a></li>
          <li[#if (menuSelection!'') == 'results'] id="current"[/#if]><a href="/results"><span>Results</span></a></li>
          <li[#if (menuSelection!'') == 'submit'] id="current"[/#if]><a href="/submit"><span>Submit</span></a></li>
          <li>
            [#if user.loggedIn]
              <a href="${logoutUrl}"><span>Logout</span></a>
            [#else]
              <a href="${loginUrl}"><span>Login</span></a>
            [/#if]
          </li>
        </ul>                  
      </div>
    
      <div id="content-wrap">
        <img src="/img/headerphoto.jpg" width="970" height="120" alt="headerphoto" class="header-photo">
        [#nested/]
      </div>
      
      <div id="footer">
        <div class="footer-left">
          <p class="align-left">
            Powered by <a href="https://cloud.google.com/appengine/">Google App Engine</a>
          </p>
        </div>
        <div class="footer-left">
          <p class="align-center">Inspired by 
            <a href="http://www.java4k.com/">java4k.com</a>, 
            <a href="http://js13kgames.com/">js13kgames.com</a>, and 
            <a href="http://js1k.com/">js1k.com</a></p>
        </div>
        <div class="footer-right">
          <p class="align-right">
            Website template by <a href="http://www.styleshout.com/">styleshout</a>
          </p>
        </div>
      </div>
    </div>
  </body>
</html>
[/#macro]
