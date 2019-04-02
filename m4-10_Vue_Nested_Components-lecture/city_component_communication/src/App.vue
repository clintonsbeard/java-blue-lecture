<template>
  <div id="app">
    <!-- The City Detail Component definition  (Shows a single City)
      v-if   - Only show this component when the citySelection component is NOT empty (has keys)
      v-bind - bind the CityDetail city prop to the citySelection data element of this component
      v-on   - event handler for "show-all-cities", when caught, it sets the citySelection variable
               to an empty Object, that causes this component to be removed and the City (list) component
               to be shown.
    -->
    <city-detail  v-if="Object.keys(citySelection).length > 0" 
      v-bind:city="citySelection" 
      v-on:show-all-cities="citySelection = {}"></city-detail>
    <!-- The City Component defintion (show the City List)
        v-if   - Only show this component when the citySelection component is empty (has NO keys)
        v-bind - binds the cities prop (Array) on the City component to the cityList data variable of
                 this component
        v-on   - event handler for "city-selected".  It calls the handleCitySelection method and by
                 default passes it the event object, which is the selectedCity. 
    -->
    <city v-if="Object.keys(citySelection).length === 0" 
      v-bind:cities="cityList" 
      v-on:city-selected="handleCitySelection"></city>
  </div>
</template>

<script>
import City from './components/City.vue'
import CityDetail from './components/CityDetail.vue'

export default {
  name: 'app',
  components: {
    City,
    CityDetail

  },
  data() {
    return {
        /* The citySelected by the user.  This will be populated when the city-selected event 
         * is caught, and returned to empty when the "show-all-cities" event is caught.   Which
         * child component (City or CityDetail) that is shown is dependent on whether this object is
         * populated.  It will be passed to the CityDetail component, when populated, for it to display
         * the City Details.
         */
          citySelection: {},
          // The list of cities to be passed to the City Component which will display them
          cityList: [
              {
                  id: 1,
                  name: 'Columbus',
                  district: 'Ohio',
                  countryCode: 'USA',
                  population: 711470
              },
              {
                  id: 2,
                  name: 'Cleveland',
                  district: 'Ohio',
                  countryCode: 'USA',
                  population: 478403
              },
              {
                  id: 3,
                  name: 'London',
                  district: 'England',
                  countryCode: 'GBR',
                  population: 7285000
              },
              {
                  id: 4,
                  name: 'Seoul',
                  district: 'Seoul',
                  countryCode: 'KOR',
                  population: 9981619
              },
              {
                  id: 5,
                  name: 'Tokyo',
                  district: 'Tokyo-to',
                  countryCode: 'JPN',
                  population: 7980230
              },
              {
                  id: 6,
                  name: 'Pittsburgh',
                  district: 'Pennsylvania',
                  countryCode: 'USA',
                  population: 334563
              },
              {
                  id: 7,
                  name: 'Detroit',
                  district: 'Michigan',
                  countryCode: 'USA',
                  population: 951270
              },
              {
                  id: 8,
                  name: 'Cincinnati',
                  district: 'Ohio',
                  countryCode: 'USA',
                  population: 331285
              }

          ]
        }
    },
    methods: {
      /*
      * The method that will handle the city-selected event.  It uses the city object passed in
      * the event, selectedCity, and sets it to the citySelection variable in this component.
      */
      handleCitySelection(selectedCity) {
        this.citySelection = selectedCity;
      }
    }
  }

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
body {
  background: linear-gradient(45deg,  rgba(66, 183, 245,0.8) 0%,rgba(66, 245, 189,0.4) 100%);
}
</style>
