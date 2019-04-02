<!-- The CityDetail component displays a single city passed to by the parent component -->
<template>
  <div class="cityDetailMain">
      <div class="city">
            <h1>{{ city.name }} Detail</h1>
            <div class="cityRow">
                <div class="rowTitle">Country</div>
                <div class="rowData">{{ city.countryCode }}</div>
            </div>
            <div class="cityRow">
                <div class="rowTitle">District</div>
                <div class="rowData">{{ city.district }}</div>
            </div>
            <div class="cityRow bottomRow">
                <div class="rowTitle">Population</div><div class="rowData">{{ city.population }}</div>
            </div>
            <div class="showAlllDiv">
                <!-- The click event for the anchor with the text "Show All Cities" has an
                     event handler that prevents the links default behavior, and raises an
                     event named "show-all-cites".  This event just tells the parent component
                     that the link was clicked, so there are no arguments passed -->
                <a href="#" @click.prevent="$emit('show-all-cities')">Show All Cities</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'city-detail',
    props: {
        // The city object will be passed to this component by its parent component
        city: Object
    }
}
</script>

<style>
div.cityDetailMain {
    border: 1px solid black;
    width: 40%;
    min-width: 250px;
    margin: auto;
    border-radius: 25px;
    padding: 10px; 
    background: azure;
}
div.city {
    width: 200px;
    margin: auto;
}
div.showAlllDiv {
    padding-top: 10px;
}
</style>
