<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="account">
  <img src="img/piggybank.png" alt="Start Savings">
  <h2 id="savings" class="heading">Start Saving</h2>
  <p>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sagittis maximus commodo. Donec vestibulum ac elit sed dignissim. Cras eleifend molestie odio, vel malesuada dolor suscipit vitae. Phasellus non tortor quis nibh consequat condimentum. Mauris interdum, quam eu sodales porttitor, elit quam molestie ipsum, dictum rutrum orci neque eget sapien. Sed ac scelerisque nulla. Cras blandit erat nec dolor iaculis, id accumsan dui viverra. Sed sit amet augue ex. Nullam et blandit erat. Aliquam in dui vel nisl bibendum mollis in vel ipsum. Nunc scelerisque ex non nulla rhoncus porta. Suspendisse est elit, eleifend et facilisis at, porttitor sed nisl. Sed ante libero, accumsan quis lobortis ac, consectetur id eros.
  </p>
  <ul>
    <li>One</li>
    <li>Two</li>
    <li>Three</li>
  </ul>
</section>
<section class="account">
  <img src="img/checkandpen.png" alt="Open Checking">
  <h2 id="checkings" class="heading">Open Checking</h2>
  <p>
    Integer at vestibulum libero. Nullam suscipit luctus est ac faucibus. Mauris non nibh elit. Nulla porta at velit ac gravida. Vivamus viverra ante at tortor ultricies mollis. Nam commodo, ante eu volutpat efficitur, tortor ex mollis est, ut finibus ante velit cursus ligula. Nulla augue nibh, faucibus ac mollis nec, commodo blandit urna. Phasellus vestibulum lacus ante, vel ullamcorper velit fringilla nec. Fusce rhoncus urna ut magna venenatis efficitur nec eget augue. Nam tincidunt neque eu ligula hendrerit, ac convallis sem hendrerit. Ut ornare, nisi non dignissim commodo, augue nibh pellentesque tortor, a porttitor est erat vel arcu. Integer in elit non lorem iaculis tincidunt id eu arcu.
  </p>
  <p>
  	<c:url var="checkingApplicationHref" value="/checkingApplication/" />
  	<a href="${checkingApplicationHref}">Open a New Account</a>
  </p>
</section>
<section class="account">
  <img src="img/dollarsign.png" alt="Bridge the Gap">
  <h2 id="loans" class="heading">Loans</h2>
  <p>
    Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis est lorem, porta quis luctus vel, iaculis quis libero. Ut sodales dapibus lacinia. Cras vehicula pharetra arcu, egestas egestas mi aliquam ac. Donec tempus justo suscipit felis eleifend laoreet. Aenean blandit dolor est, sed suscipit metus luctus et. Vivamus fermentum sem in mi cursus, id porta sapien dapibus. Phasellus et dolor et purus suscipit cursus vel eu elit. Nulla dictum est molestie purus cursus tincidunt. Vivamus dictum sapien eget dui faucibus, quis cursus leo tincidunt. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam erat volutpat. Fusce venenatis eros non neque mollis posuere. Maecenas felis nisi, feugiat a faucibus nec, luctus sit amet dui.
  </p>
  <p>
  	<a href="mortgageCalculatorInput">Mortgage Payment Calculator</a>
  </p>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />