<template>
    <div id="bean" class="row">
        <v-app dark style="width:100%;height:80%;">
            <v-container grid-list-md text-xs-center fluid 
                v-if = "!isLoading">
                <v-layout row wrap >
                    <v-row justify="space-around" >
                        <v-card width="100%">
                            <v-img
                            height="200px"
                            src="https://miro.medium.com/max/1400/1*XiML5rUROwZ76MyHYONTSg.png"
                            >
                                <v-card-title class="amber--text mt-8">
                                    <v-avatar size="56">
                                    <img
                                        alt="user"
                                        src="https://www.logolynx.com/images/logolynx/d0/d0c486f981d3120338b692278298484a.jpeg"
                                    >
                                    </v-avatar>
                                    <p class="ml-3 blue--text text--lighten-5" v-if="informationMonitor.app">
                                        {{ informationMonitor.app.name}}
                                    </p>

                                </v-card-title>
                            </v-img>
                            <v-card-text>
                                <div class="font-weight-bold ml-8 mb-2">
                                    Bean Info
                                </div>
                            </v-card-text>
                        </v-card>
                    </v-row>
               </v-layout>
               
            </v-container>
                <v-data-iterator
                    :items="items"
                    :items-per-page.sync="itemsPerPage"
                    :page.sync="page"
                    :search="search"
                    :sort-by="sortBy.toLowerCase()"
                    :sort-desc="sortDesc"
                    hide-default-footer
                    >
                    <template v-slot:header>
                        <v-toolbar
                        dark
                        color="blue darken-3"
                        class="mb-1"
                        >
                        <v-text-field
                            v-model="search"
                            clearable
                            flat
                            solo-inverted
                            hide-details
                            prepend-inner-icon="mdi-magnify"
                            label="Search"
                        ></v-text-field>
                        <template v-if="$vuetify.breakpoint.mdAndUp">
                            <v-spacer></v-spacer>
                            <v-select
                            v-model="sortBy"
                            flat
                            solo-inverted
                            hide-details
                            :items="keys"
                            prepend-inner-icon="mdi-magnify"
                            label="Sort by"
                            ></v-select>
                            <v-spacer></v-spacer>
                            <v-btn-toggle
                            v-model="sortDesc"
                            mandatory
                            >
                            <v-btn
                                large
                                depressed
                                color="blue"
                                :value="false"
                            >
                                <v-icon>mdi-arrow-up</v-icon>
                            </v-btn>
                            <v-btn
                                large
                                depressed
                                color="blue"
                                :value="true"
                            >
                                <v-icon>mdi-arrow-down</v-icon>
                            </v-btn>
                            </v-btn-toggle>
                        </template>
                        </v-toolbar>
                    </template>

                    <template v-slot:default="props">
                        <v-row>
                        <v-col
                            v-for="item in props.items"
                            :key="item.name"
                            cols="12"
                            sm="6"
                            md="4"
                            lg="3"
                        >
                            <v-card>
                            <v-card-title class="subheading font-weight-bold">
                                <v-icon>mdi-saw-blade</v-icon> 
                                {{ item.name }}
                            </v-card-title>

                            <v-divider></v-divider>

                            <v-list dense>
                                <v-list-item
                                v-for="(key, index) in filteredKeys"
                                :key="index"
                                >
                                <v-list-item-content :class="{ 'blue--text': sortBy === key }">
                                    {{ key }}:
                                </v-list-item-content>
                                <v-list-item-content
                                    class="align-end text-left "
                                    :class="{ 'blue--text': sortBy === key }"
                                >
                                    <v-card-text >
                                        {{ item[key.toLowerCase()] }}
                                    </v-card-text>
                                </v-list-item-content>
                                </v-list-item>
                            </v-list>
                            </v-card>
                        </v-col>
                        </v-row>
                    </template>

                    <template v-slot:footer>
                        <v-row
                        class="mt-2"
                        align="center"
                        justify="center"
                        >
                        <span class="grey--text">Items per page</span>
                        <v-menu offset-y>
                            <template v-slot:activator="{ on, attrs }">
                            <v-btn
                                dark
                                text
                                color="primary"
                                class="ml-2"
                                v-bind="attrs"
                                v-on="on"
                            >
                                {{ itemsPerPage }}
                                <v-icon>mdi-chevron-down</v-icon>
                            </v-btn>
                            </template>
                            <v-list>
                            <v-list-item
                                v-for="(number, index) in itemsPerPageArray"
                                :key="index"
                                @click="updateItemsPerPage(number)"
                            >
                                <v-list-item-title>{{ number }}</v-list-item-title>
                            </v-list-item>
                            </v-list>
                        </v-menu>

                        <v-spacer></v-spacer>

                        <span
                            class="mr-4
                            grey--text"
                        >
                            Page {{ page }} of {{ numberOfPages }}
                        </span>
                        <v-btn
                            fab
                            dark
                            color="blue darken-3"
                            class="mr-1"
                            @click="formerPage"
                        >
                            <v-icon>mdi-chevron-left</v-icon>
                        </v-btn>
                        <v-btn
                            fab
                            dark
                            color="blue darken-3"
                            class="ml-1"
                            @click="nextPage"
                        >
                            <v-icon>mdi-chevron-right</v-icon>
                        </v-btn>
                        </v-row>
                    </template>
                </v-data-iterator>
        </v-app>
    </div>
</template>
<script>
import { getServiceBeans,getServiceInformation } from '@/assets/js/api/actuator'
export default {
    name: 'BeanPage',
    data () {
        return {
            informationMonitor: {},
            beansMonitor: {},
            isLoading: false,
            itemsPerPageArray: [4, 8, 12],
            search: '',
            filter: {},
            sortDesc: false,
            page: 1,
            itemsPerPage: 4,
            sortBy: 'name',
            keys: [
                'Name',
                'Scope',
                'Type',
                'Resource',
                'Dependencies'
            ],
            items:[]
        }
    },
    methods: {
        getServiceInformation() {
            this.isLoading=true;
            getServiceInformation().then((response) => {
                this.informationMonitor = response.data;
                this.isLoading = false;
            })
              .catch((error) => {
                  console.log(error);
              })
        },
        getServiceBeans() {
            this.isLoading = true;
            getServiceBeans().then((response) => {
                this.beansMonitor = response.data;
                if ( this.beansMonitor && 
                     this.beansMonitor.contexts && 
                     this.beansMonitor.contexts.application &&
                     this.beansMonitor.contexts.application.beans ) {
                    Object.keys(this.beansMonitor.contexts.application.beans).forEach(key=> {
                        
                       this.items.push({
                           name: key,
                           scope: this.beansMonitor.contexts.application.beans[key].scope,
                           type: this.beansMonitor.contexts.application.beans[key].type,
                           resource: this.beansMonitor.contexts.application.beans[key].resource,
                           dependencies :  this.beansMonitor.contexts.application.beans[key].dependencies.join('\n')
                       })
                    });
                }
                this.isLoading = false;
            })
              .catch((error) => {
                  console.log(error);
              })
        },
        nextPage () {
            if (this.page + 1 <= this.numberOfPages) this.page += 1
        },
        formerPage () {
            if (this.page - 1 >= 1) this.page -= 1
        },
        updateItemsPerPage (number) {
            this.itemsPerPage = number
        }
    },
    computed: {
      numberOfPages () {
        return Math.ceil(this.items.length / this.itemsPerPage)
      },
      filteredKeys () {
        return this.keys.filter(key => key !== 'Name')
      },
    },
    mounted() {
        this.getServiceInformation();
        this.getServiceBeans();
    }
}
</script>
<style scoped>
#info {
  margin-top: 0 px;
  padding-left: 5px;
}
.text-left {
    text-align:left;
}

</style>

