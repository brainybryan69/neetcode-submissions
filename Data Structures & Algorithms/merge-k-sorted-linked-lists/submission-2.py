# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        def mergeTwoLists(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
            if not list2:
                return list1
            if not list1:
                return list2

            if list1.val <= list2.val:
                newList = list1.next
                list1.next = mergeTwoLists(newList, list2)
                return list1
            else:
                newList = list2.next
                list2.next = mergeTwoLists(list1, newList)
                return list2
            
            return None
        
        if len(lists) == 0:
            return None
        
        result = []
        tmp = lists

        while True:
            for i in range(0, len(tmp), 2):
                l1 = tmp[i]
                if i + 1 == len(tmp):
                    result.append(l1)
                else:
                    l2 = tmp[i + 1]
                    result.append(mergeTwoLists(
                        l1, l2
                    ))
            if len(result) == 1: 
                return result[0]
            else: 
                tmp = result
                result = []
            

