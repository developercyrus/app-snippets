freemarker template test:
string test-----------${user}-----------${number}-----------${latestProduct.url}-----------${latestProduct.name}
condition test-----------
<#if user == "Small John">
    list iterator-----------
    <#list list as aa>
        ${aa}
    </#list> 
</#if>
