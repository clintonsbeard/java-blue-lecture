<!-- The City Component displays a list of cities passed to it by its parent component -->

<template>
    <div class="cityMain">
        <h1>Cities</h1>
        <div class="cityList">
            <div class="city" v-for="city in cities" :key="city.id">
                <!-- The click event calls SelectCityById with the city Id -->
                <h2  @click.prevent="selectCityById(city.id)">{{city.name}}</h2>
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
            </div>
     </div>
  </div>
</template>


<script>
export default {
    name: 'city',
    props: {
        // The prop "cities" allows for the Array of cities to be sent by the parent
        cities: Array  
    },
    data() {
        return {
            // An empty selected city object to be returned by the component
            selectedCity: {}
        }
    },
    methods: {
       /** 
        * Selects the City by Id
        * @argument id - the City Id
        */
        selectCityById(id) {
            // Find the City by the passed City Id in the Array of Cities
            this.selectedCity = this.cities.find(city => city.id == id);
            /*
             * Raise a new event named "city-selected" and pass the city 
             * the user selected as the event argument
            */
            this.$emit('city-selected', this.selectedCity);
        }
    }
}
</script>

<style>
div.cityList {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}

div.cityList div.city { 
    border-radius: 25px;
    padding: 20px; 
    width: 200px;
    border: 2px solid black;
    margin: 1rem;
    background-color:azure;
    background: linear-gradient( rgba(66, 183, 245, 0.8) 40%, azure 30%);
}

div.cityLinkDiv {
  margin-bottom: 50px;
}

div.cityList div.city h2 {
    padding-bottom: 10px;
    color: azure;
    text-shadow: 2px 2px 5px black;
    justify-content: space-around;
}

div.cityRow {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
    height: 30px;   
    line-height: 30px;
    border-bottom: 1px solid lightgray;
    font-family: 'Roboto', sans-serif;
}
div.cityRow > div.rowTitle {
    width: 50%;
    text-align:left;
    font-weight: 800;
    
}
div.cityRow > div.rowData {
    width: 50%;
}

div.bottomRow {
    border-bottom: 0px;
}

div.city h2:hover {
    cursor: pointer;
    font-weight: 750;
    text-decoration: underline;
}

</style>
